package com.touchableheroes.drafts.spacerx.dom;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by asiebert on 11.04.2017.
 */

public interface DOMChangeListener {

/*
    public void changed(final Enum key,
                        final Serializable oldVal,
                        final Serializable newVal);
*/

    public void changed(Map<Enum, Serializable> changedMap);
}
