package com.touchableheroes.drafts.spacerx.dom;


import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by asiebert on 08.04.2017.
 */

public class SyntheticDomFactory {

    public static void create(SyntheticDOMBinding binding) {

    }

    public static SyntheticDOM createFor(final Fragment fragement) {
        final DOM dom = HasDOMSupport.getDOM();
        // appCtx = fragement.getActivity().getApplication();

        return new SyntheticDOMImpl( dom );
    }

}
