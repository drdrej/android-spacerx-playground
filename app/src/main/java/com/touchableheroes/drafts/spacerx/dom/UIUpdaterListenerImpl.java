package com.touchableheroes.drafts.spacerx.dom;

import android.view.View;

import com.touchableheroes.drafts.spacerx.droid.ui.UIUpdater;

import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Map;

/**
 * Created by asiebert on 11.04.2017.
 */

public class UIUpdaterListenerImpl implements UIUpdaterListener {

    private final Enum boundTo;
    private final UIUpdater uiUpdater;
    private final SyntheticDOM model;
    private final WeakReference<View> backRef;

    public UIUpdaterListenerImpl(
            final SyntheticDOM src,
            final Enum boundTo,
            final UIUpdater uiUpdater,
            final WeakReference<View> view) {
        this.model = src;
        this.boundTo = boundTo;
        this.uiUpdater = uiUpdater;
        this.backRef = view;
    }

    @Override
    public void changed(final Map<Enum, Serializable> values) {
        final Serializable val = model().get( boundTo );
        uiUpdater.update( view(), val );
    }

    private View view() {
        final View view = this.backRef.get();

        if( view == null ) {
            throw new IllegalStateException( "Back.ref.view is NULL! Lost View Ref." );
        }

        return view;
    }

    private SyntheticDOM model() {
        return this.model;
    }
}
