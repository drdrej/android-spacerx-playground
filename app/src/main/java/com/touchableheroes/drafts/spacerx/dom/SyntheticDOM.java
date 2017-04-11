package com.touchableheroes.drafts.spacerx.dom;

import com.touchableheroes.drafts.spacerx.dom.values.Getter;

import java.io.Serializable;

/**
 * Created by asiebert on 08.04.2017.
 */

public interface SyntheticDOM {

    public DOM dom();

    public ActionExecuter actions();

    /**
     * Registriert einen neuen dynamischen Wert
     *  @param key
     * @param getter
     */
    public <T extends Serializable> void register(final Enum key,
                                                  final Getter<T> getter);


    public void addChangeListener( final UIUpdaterListener listener);

    public <V> V get( final Enum key );

    public void unbind();
}
