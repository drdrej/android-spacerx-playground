package com.touchableheroes.drafts.spacerx.db;

import com.touchableheroes.drafts.db.cupboard.xt.config.DbConfig;
import com.touchableheroes.drafts.db.cupboard.xt.provider.CupboardContentProvider;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.provider.ContentProviderApiContract;

/**
 * Created by asiebert on 14.04.2017.
 */
public class AppContentProvider
        extends CupboardContentProvider {


    public AppContentProvider() {
        super( DbConfig.from(ContentProviderApiContract.class) );
    }

}
