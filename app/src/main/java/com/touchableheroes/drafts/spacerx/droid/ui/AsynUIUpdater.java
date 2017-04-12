package com.touchableheroes.drafts.spacerx.droid.ui;

import android.os.Handler;
import android.view.View;

import java.io.Serializable;

/**
 * Created by asiebert on 12.04.2017.
 */
public abstract class AsynUIUpdater<V extends View,
                                    S extends Serializable>
        extends UIUpdater<V,S> {

    private final Handler handler = new Handler();

    @Override
    public void update(final V view, final S val) {
        final Runnable msg = new Runnable() {

            @Override
            public void run() {
                delayed(view, val);
            }
        };

        handler.postDelayed(msg, 1000);
    }

    public abstract void delayed(final V view, final S val);

}
