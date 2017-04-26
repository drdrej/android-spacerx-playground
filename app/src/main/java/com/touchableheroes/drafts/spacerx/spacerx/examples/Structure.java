package com.touchableheroes.drafts.spacerx.spacerx.examples;

import com.touchableheroes.drafts.spacerx.GetterByEnum;

import java.util.EnumSet;

/**
 * Created by asiebert on 26.04.2017
 * .
 */

public class Structure<K extends Enum>
        implements GetterByEnum<K> {

    private final Object[] values;

    public Structure( final Object... values ) {
        this.values = values;
    }

    public Structure( final Class<K> keyType,
                      final Object... values ) {
        this.values = values;
    }

    public boolean check( final Class<K> keyType ) {
        return (EnumSet.allOf( keyType ).size() == values.length);
    }

    public void modify( final K key, final Object value) {
        values[ key.ordinal() ] = value;
    }

    @Override
    public <V> V get(final K key) {
        return (V) values[ key.ordinal() ];
    }

}
