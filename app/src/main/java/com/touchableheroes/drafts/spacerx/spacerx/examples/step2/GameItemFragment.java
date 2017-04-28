package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.touchableheroes.drafts.db.cupboard.xt.loader.CupboardLoaderCallback;
import com.touchableheroes.drafts.db.cupboard.xt.loader.CursorIteratorConverter;
import com.touchableheroes.drafts.db.cupboard.xt.loader.impl.DBLoader;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.dummy.DummyContent;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.dummy.DummyContent.DummyItem;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.LoaderIDs;

/**
 *
 */
public class GameItemFragment
       extends Fragment {


    public GameItemFragment() {
        ;
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

            recyclerView.setAdapter(new GameItemRecyclerViewAdapter(DummyContent.ITEMS));
        }

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        final DBLoader tx = new DBLoader(getLoaderManager());
        tx.load(LoaderIDs.All_GAMEZ,
                new CupboardLoaderCallback<LoaderIDs, Object>(
                        LoaderIDs.All_GAMEZ, context) {

                    @Override
                    public void onLoadFinished(
                            final CursorIteratorConverter<Object> data) {

                        // System.out.print("!! --> DATA: " + data);
        /*
                        Toast.makeText(getActivity(), "[!] Track loaded! ", Toast.LENGTH_SHORT );

                        getListAdapter().swapCursor(data.getCursor());
                        */
                    }

                    @Override
                    public void onLoaderReset() {
                        System.out.println("!! --> DATA: reset.");
                    }
                });
    }

}
