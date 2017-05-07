package com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity;

import com.touchableheroes.drafts.db.cupboard.xt.contracts.SQliteTypeContract;
import com.touchableheroes.drafts.db.cupboard.xt.cursor.mapping.LongSQLite;
import com.touchableheroes.drafts.db.cupboard.xt.cursor.mapping.StringSQLite;

/**
 * Created by asiebert on 04.05.2017.
 */
public enum GameEntityProjection {

    @SQliteTypeContract(
            type = LongSQLite.class
    )
    _id,

    @SQliteTypeContract(
            type = StringSQLite.class
    )
    name,

    @SQliteTypeContract(
            type = LongSQLite.class
    )
    _createdAt
}
