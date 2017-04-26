package com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model;

import com.touchableheroes.drafts.db.cupboard.xt.DbConfig;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity.GameEntity;

/**
 * Created by asiebert on 17.04.2017.
 */
public class AppConfig {

    private static AppConfig INSTANCE = new AppConfig();

    public DbConfig db() {
        return new DbConfig(
                "com.touchableheroes.playground.spacerx",
                1,
                new Class[] { GameEntity.class},
                LoaderIDs.class);
    }

    public static AppConfig config() {
        return INSTANCE;
    }

}
