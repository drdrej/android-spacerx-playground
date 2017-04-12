package com.touchableheroes.drafts.spacerx.droid.ui;

import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.UIUpdaterListenerImpl;

import java.lang.ref.WeakReference;

/**
 * Created by asiebert on 08.04.2017.
 */

public class ViewBinding {

    private final WeakReference<View> owner;

    private final SyntheticDOM syntheticDom;

    private Enum boundTo;

    public ViewBinding(
            final View view,
            final SyntheticDOM synth) {
        this.owner = new WeakReference<View>(view);
        this.syntheticDom = synth;
    }

    public ViewBinding click(final UIAction clickListener) {
        final View owner = view();
        owner.setOnClickListener( new View.OnClickListener() {

            @Override
            public void onClick(final View view) {
                clickListener.action(view);
            }
        });
        return this;
    }

    public final <V extends View> V view( ) {
        final View rval = this.owner.get();

        if( rval == null ) {
            throw new IllegalStateException( "Back.ref.view is NULL! Lost View Ref." );
        }

        return (V) rval;
    }

    public ViewBinding updater(final UIUpdater uiUpdater) {
        this.syntheticDom.addChangeListener(
                new UIUpdaterListenerImpl(
                        syntheticDom,
                        boundTo,
                        uiUpdater,
                        owner ));

        return this;
    }

    public ViewBinding value(final Enum key) {
        this.boundTo = key;
        return this;
    }

}
