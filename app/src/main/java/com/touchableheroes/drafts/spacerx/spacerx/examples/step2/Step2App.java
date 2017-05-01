package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.app.Application;

import com.touchableheroes.drafts.db.cupboard.xt.provider.CupboardSQLiteDBHelper;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.ContentProviderApiContract;


/**
 * Created by asiebert on 15.04.2017.
 */

public class Step2App extends Application {

    private CupboardSQLiteDBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();

        this.dbHelper = new CupboardSQLiteDBHelper(
                getApplicationContext(),
                ContentProviderApiContract.class );
    }

    public CupboardSQLiteDBHelper getDbHelper() {
        return dbHelper;
    }

}
