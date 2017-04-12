package com.touchableheroes.drafts.spacerx.droid.ui;

import android.view.View;

import java.io.Serializable;

/**
 * Created by asiebert on 12.04.2017.
 */

public class AsyncUIUpdater<V extends View, S extends Serializable>
        extends AbstractAsynUIUpdater<V, S> {

    private final UIUpdater<V, S> updater;

    public AsyncUIUpdater(final UIUpdater<V, S> updater ) {
        this.updater = updater;
    }

    @Override
    protected void delayed(final V view,
                           final S val) {

        updater.update(view, val);
    }

}
