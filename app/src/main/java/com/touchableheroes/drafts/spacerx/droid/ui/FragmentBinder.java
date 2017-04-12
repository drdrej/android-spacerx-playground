package com.touchableheroes.drafts.spacerx.droid.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.values.Getter;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDomFactory;

import java.io.Serializable;
import java.lang.ref.WeakReference;


/**
 * Created by asiebert on 08.04.2017.
 */
public abstract class FragmentBinder
        extends AbstractUIBinder {

    private final WeakReference<Fragment> src;

    public final SyntheticDOM synthDom;

    public FragmentBinder(final Fragment src) {
        this.src = new WeakReference<Fragment>(src);
        this.synthDom = SyntheticDomFactory.create();;
    }

    @Override
    protected View view() {
        return fragment().getView();
    }


    private Fragment fragment() {
        final Fragment fragment = this.src.get();

        if( fragment == null ) {
            throw new IllegalStateException( "Backref.Fragement is broken/ maybe destroyed." );
        }

        return null;
    }


}
