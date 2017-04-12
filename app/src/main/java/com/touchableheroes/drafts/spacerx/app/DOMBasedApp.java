package com.touchableheroes.drafts.spacerx.app;

import android.app.Application;

import com.touchableheroes.drafts.spacerx.dom.HasDOMSupport;

/**
 * Created by asiebert on 10.04.2017.
 */

public class DOMBasedApp extends Application {

    {
        HasDOMSupport.initDOM();
    }

    @Override
    public void onCreate() {
        super.onCreate();

    }


}
