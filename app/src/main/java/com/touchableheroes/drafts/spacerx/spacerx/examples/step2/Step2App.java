package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.app.Application;

import com.touchableheroes.drafts.db.cupboard.xt.CupboardSQLiteDBHelper;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.AppConfig;

/**
 * Created by asiebert on 15.04.2017.
 */

public class Step2App extends Application {

    private CupboardSQLiteDBHelper dbHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        this.dbHelper = new CupboardSQLiteDBHelper( getApplicationContext(), AppConfig.config().db() );
    }

    public CupboardSQLiteDBHelper getDbHelper() {
        return dbHelper;
    }

}