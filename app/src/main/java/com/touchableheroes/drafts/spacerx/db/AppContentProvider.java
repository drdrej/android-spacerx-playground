package com.touchableheroes.drafts.spacerx.db;

import android.content.UriMatcher;

import com.touchableheroes.drafts.db.cupboard.xt.CupboardContentProvider;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.AppConfig;

/**
 * Created by asiebert on 14.04.2017.
 */
public class AppContentProvider
        extends CupboardContentProvider {

    public AppContentProvider() {
        super( AppConfig.config().db() );
    }


}
