package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.touchableheroes.drafts.core.logger.Fact;
import com.touchableheroes.drafts.core.logger.Tracer;
import com.touchableheroes.drafts.core.obj.Structure;
import com.touchableheroes.drafts.db.cupboard.xt.cursor.ConverterCursorList;
import com.touchableheroes.drafts.db.cupboard.xt.defaults.NoDataCursor;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.projections.GameEntityProjection;

/**
 *
 */
public class GameItemRecyclerViewAdapter
       extends RecyclerView.Adapter<GameItemRecyclerViewAdapter.ViewHolder> {

    private ConverterCursorList<GameEntityProjection> mValues;

    public GameItemRecyclerViewAdapter() {
        mValues = new ConverterCursorList<GameEntityProjection>( new NoDataCursor(), GameEntityProjection.class );
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

        final String id =  String.valueOf( holder.mItem.get(GameEntityProjection._id ));
        holder.mIdView.setText( id );

        final String name = String.valueOf( holder.mItem.get(GameEntityProjection.name));
        holder.mContentView.setText( name );

        System.err.println( ">>> ID: " + id + " -> " + name );
        holder.mView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            // bind space
            }
        });
    }

    public void updateData( final ConverterCursorList<GameEntityProjection> data ) {
        this.mValues = data;

        Tracer.prove(new Fact() {
            @Override
            public void check() {
                if( data == null ) {
                    throw new IllegalStateException( "parameter:data is NULL. not supported parameter-value." );
                }
            }
        });

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

        public Structure<GameEntityProjection> mItem;

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
