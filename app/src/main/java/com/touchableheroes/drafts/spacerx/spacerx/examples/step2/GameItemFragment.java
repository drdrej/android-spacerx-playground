package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchableheroes.drafts.db.cupboard.xt.loader.ContractLoaderCallback;
import com.touchableheroes.drafts.db.cupboard.xt.loader.impl.SimpleContractLoader;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step1.ExampleAppStateKey;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.ContentProviderApiContract;
import com.touchableheroes.drafts.spacerx.ui.FragmentBinder;
import com.touchableheroes.drafts.spacerx.ui.UIUpdater;

import java.io.Serializable;

/**
 *
 */
public class GameItemFragment
       extends Fragment {


    private GameItemRecyclerViewAdapter adapter;

    private SimpleContractLoader loaderMgr;


    class Binder extends FragmentBinder {
        public Binder(final Fragment src) {
            super(src);
        }

        @Override
        public void bind() {
            bind(R.id.content)
                    .value( ExampleAppStateKey.LOADER_ALL_GAMEZ_COUNT )
                    .updater(new UIUpdater() {

                        @Override
                        public void update(final View view,
                                           final Serializable serializable) {


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
    public void onAttach(Context context) {
        super.onAttach(context);

        this.loaderMgr = new SimpleContractLoader(getLoaderManager(), context);

        final String[] args = null;

        loaderMgr.load(
                new ContractLoaderCallback(
                        ContentProviderApiContract.All_GAMEZ,
                        args) {

                    @Override
                    public void onLoadFinished(
                            final Object data) {
                        updateListData( (Cursor) data );
                    }

                });
    }


    protected void updateListData(final Cursor data) {
        System.out.println( ">>> update cursor data in view..." );
        adapter.updateData( new GameItemRecyclerViewAdapter.ListImpl(data) );
    }

}
