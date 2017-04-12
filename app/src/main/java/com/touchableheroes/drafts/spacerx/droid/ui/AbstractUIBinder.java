package com.touchableheroes.drafts.spacerx.droid.ui;

import android.content.Context;
import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDomFactory;
import com.touchableheroes.drafts.spacerx.dom.values.Getter;

import java.io.Serializable;

/**
 * Created by asiebert on 12.04.2017.
 */
public abstract class AbstractUIBinder {

    private final SyntheticDOM synthDom;

    protected abstract View view();

    public AbstractUIBinder() {
        this.synthDom = SyntheticDomFactory.create();
    }

    public SyntheticDOM syntheticDom() {
        return synthDom;
    }

    public abstract void bind();

    public abstract void init(final Context ctx);

    public void destroy() {
        this.syntheticDom().unbind();
    }

    protected <T extends Serializable> void getter(
            final Enum key,
            final Getter<T> getterImpl) {
        syntheticDom().register(key, getterImpl);
    }


    protected ViewBinding bind(final int id) {
        final View view = view().findViewById(id);

        if( view == null ) {
            throw new IllegalStateException( ("View not found. ID = " + id) );
        }

        try {
            return new ViewBinding( view, syntheticDom() );
        } catch (final ClassCastException ccx) {
            throw new IllegalStateException( "Cast not correct. View is of type [= " + view.getClass().getName() + "]" );
        }
    }
}
