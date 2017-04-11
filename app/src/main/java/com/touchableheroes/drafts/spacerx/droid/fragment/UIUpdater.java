package com.touchableheroes.drafts.spacerx.droid.fragment;

import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

/**
 * Created by asiebert on 11.04.2017.
 */

public abstract class UIUpdater<V extends View, S extends Serializable> {

    public UIUpdater() {
        ;
    }

    public abstract void update(final V view, final S val);

    public static class TextViewUIUpdater
           extends UIUpdater<TextView, String> {

        @Override
        public void update(
                final TextView view, final String value) {

            view.setText( value );
        }
    }
}
