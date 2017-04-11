package com.touchableheroes.drafts.spacerx.droid.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.touchableheroes.drafts.spacerx.dom.values.Getter;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDomFactory;

import java.io.Serializable;


/**
 * Created by asiebert on 08.04.2017.
 */
public abstract class FragmentBinder {

    private final Fragment src;

    public SyntheticDOM synthDom;

    public FragmentBinder(final Fragment src) {
        this.src = src;
        this.synthDom = SyntheticDomFactory.createFor(src);;
    }

    protected ViewBinding bind(final int id) {
        final View view = this.src.getView().findViewById(id);

        if( view == null ) {
            throw new IllegalStateException( ("View not found. ID = " + id) );
        }

        try {
            return new ViewBinding( view, this.synthDom );
        } catch (final ClassCastException ccx) {
            throw new IllegalStateException( "Cast not correct. View is of type [= " + view.getClass().getName() + "]" );
        }
    }


    public SyntheticDOM syntheticDom() {
        return synthDom;
    }

    public abstract void bind();

    public abstract void init(final Context ctx);

    public void destroy() {
        ;
    }


    protected <T extends Serializable> void getter(
            final Enum key,
            final Getter<T> getterImpl) {
        syntheticDom().register(key, getterImpl);
    }

}
