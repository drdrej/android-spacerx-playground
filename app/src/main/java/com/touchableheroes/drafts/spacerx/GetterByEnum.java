package com.touchableheroes.drafts.spacerx;

/**
 * Created by asiebert on 26.04.2017.
 */

public interface GetterByEnum<K extends Enum> {

    public <V> V get( K key );

}
