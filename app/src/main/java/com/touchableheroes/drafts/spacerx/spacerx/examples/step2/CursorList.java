package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.database.Cursor;

import com.touchableheroes.drafts.db.cupboard.xt.defaults.NoDataCursor;

import java.util.AbstractList;
import java.util.List;

/**
 * Created by asiebert on 01.05.2017.
 */

public abstract class CursorList<E> extends AbstractList<E> {

    private final Cursor cursor;

    public CursorList(final Cursor src){
       this.cursor = src == null ? new NoDataCursor() : src;
    }

    @Override
    public E get(final int index) {
        // TODO defensive
        cursor.moveToPosition(index);

        return parse(cursor);
    }

    public abstract E parse(final Cursor cursor);

    @Override
    public int size() {
        return cursor.getCount();
    }

}
