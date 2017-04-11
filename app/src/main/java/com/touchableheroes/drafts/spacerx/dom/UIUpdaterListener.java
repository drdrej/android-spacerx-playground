package com.touchableheroes.drafts.spacerx.dom;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by asiebert on 11.04.2017.
 */

public interface UIUpdaterListener {

    public void changed( final Map<Enum, Serializable> values);
}
