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
import com.touchableheroes.drafts.spacerx.spacerx.R;

import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.Step2AppStateKey;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.provider.ContentProviderApiContract;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.projections.GameEntityProjection;

/**
 *
 */
public class GameItemFragment
       extends Fragment {

    private final GameItemFragementBinder binder;

    public final GameItemRecyclerViewAdapter adapter;

    public SimpleContractLoader loaderMgr;



    public GameItemFragment() {
        adapter = new GameItemRecyclerViewAdapter();
        binder = new GameItemFragementBinder(this);
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

        loaderMgr.load(
                new ContractLoaderCallback(
                        ContentProviderApiContract.All_GAMEZ,
                        null) {

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
