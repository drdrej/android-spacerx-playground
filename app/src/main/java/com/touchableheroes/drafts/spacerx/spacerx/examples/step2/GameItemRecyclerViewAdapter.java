package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.touchableheroes.drafts.db.cupboard.xt.cursor.ConverterCursorList;
import com.touchableheroes.drafts.db.cupboard.xt.cursor.CursorList;
import com.touchableheroes.drafts.db.cupboard.xt.defaults.NoDataCursor;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.dummy.DummyContent;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.dummy.DummyContent.DummyItem;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity.GameEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class GameItemRecyclerViewAdapter
       extends RecyclerView.Adapter<GameItemRecyclerViewAdapter.ViewHolder> {

    /*
     private ConverterCursorList<GameEntityProjection> mValues;
*/

    private CursorList<DummyItem> mValues;

    public static class ListImpl extends CursorList<DummyItem> {

        public ListImpl(final Cursor src) {
            super(src);
        }

        @Override
        public DummyItem parse(Cursor cursor) {
            return new DummyItem(
                    String.valueOf(Math.random()),
                    "ENTRY",
                    "DETAILS" );
        }
    };

    public GameItemRecyclerViewAdapter() {
        mValues = new ListImpl( new NoDataCursor() );
    }

    @Override
    public ViewHolder onCreateViewHolder(
            final ViewGroup parent,
            final int viewType) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_game_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            final ViewHolder holder,
            final int position ) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // bind space
            }
        });
    }

    public void updateData( final CursorList<DummyItem> data ) {
        this.mValues = data;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;

        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }

}
