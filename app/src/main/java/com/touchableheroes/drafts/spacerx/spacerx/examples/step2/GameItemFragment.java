package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchableheroes.drafts.db.cupboard.xt.cursor.ConverterCursorList;
import com.touchableheroes.drafts.db.cupboard.xt.loader.ContractLoaderCallback;
import com.touchableheroes.drafts.db.cupboard.xt.loader.impl.SimpleContractLoader;
import com.touchableheroes.drafts.spacerx.action.impl.SetValue;
import com.touchableheroes.drafts.spacerx.dom.listener.DOMChangeListener;
import com.touchableheroes.drafts.spacerx.spacerx.R;

import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.Step2AppStateKey;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.provider.ContentProviderApiContract;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.projections.GameEntityProjection;
import com.touchableheroes.drafts.spacerx.tx.Remove;
import com.touchableheroes.drafts.spacerx.ui.binding.FragmentBinder;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIUpdater;

import java.io.Serializable;
import java.util.Map;

/**
 *
 */
public class GameItemFragment
       extends Fragment {

    private final Binder binder;

    public final GameItemRecyclerViewAdapter adapter;

    public SimpleContractLoader loaderMgr;


   public static class Binder
           extends FragmentBinder {

        public Binder(final Fragment src) {
            super(src);
        }

        @Override
        public void bind() {

            bind(R.id.gamez_list)
                    .value( Step2AppStateKey.GAMEZ )
                    .updater(new UIUpdater() {

                        @Override
                        public void update(final View view,
                                           final Serializable data) {
                            // updateListData( (Cursor) data );

                            if( data != null
                                && !(data instanceof Remove)) {
                                ((GameItemFragment) owner()).adapter.updateData( (ConverterCursorList<GameEntityProjection>) data );
                            }
                        }
                    });

            onChange( Step2AppStateKey.GAMEZ )
                    .ifOneOf(new DOMChangeListener() {

                        @Override
                        public void changed(final Map<Enum, Serializable> map) {
                            final Serializable gamez = map.get(Step2AppStateKey.GAMEZ);

                            if( gamez instanceof Remove ) {
                                ((GameItemFragment) owner()).loaderMgr.reload( ContentProviderApiContract.All_GAMEZ );
                            }
                        }
                    });
        }

        @Override
        public void init(final Context context) {
            ;
        }
    };

    public GameItemFragment() {
        adapter = new GameItemRecyclerViewAdapter();
        binder = new Binder(this);
    }

    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_game_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            recyclerView.setAdapter( adapter );
        }

        return view;
    }

    @Override
    public void onViewCreated(
            final View view, @Nullable
            final Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        this.loaderMgr = new SimpleContractLoader(
                getLoaderManager(),
                this.getContext(),
                ContentProviderApiContract.class );

        final String[] args = null;

        loaderMgr.load(
                new ContractLoaderCallback(
                        ContentProviderApiContract.All_GAMEZ,
                        args) {

                    @Override
                    public void onLoadFinished(
                            final Object data) {

                        final ConverterCursorList<GameEntityProjection> cursorList = new ConverterCursorList<>(
                                (Cursor) data,
                                GameEntityProjection.class);

                        binder.syntheticDom().actions()
                                .exec( new SetValue(
                                        Step2AppStateKey.GAMEZ,
                                        cursorList) );
                    }
                });

        binder.bind();
    }


}
