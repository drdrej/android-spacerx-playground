package com.touchableheroes.drafts.spacerx.dom;


import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by asiebert on 08.04.2017.
 */

public class SyntheticDomFactory {

    public static SyntheticDOM create() {
        final DOM dom = HasDOMSupport.getDOM();

        return new SyntheticDOMImpl( dom );
    }

}
