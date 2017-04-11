package com.touchableheroes.drafts.spacerx.dom.values;

import android.support.v4.util.LongSparseArray;

import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;

import java.io.Serializable;

/**
 * Created by asiebert on 11.04.2017.
 */

public abstract class Getter<T extends Serializable> {

    private final SyntheticDOM src;

    public Getter(final SyntheticDOM src ) {
        this.src = src;
    }

    public abstract T get();

    protected SyntheticDOM syntheticDom() {
        return src;
    }

}
