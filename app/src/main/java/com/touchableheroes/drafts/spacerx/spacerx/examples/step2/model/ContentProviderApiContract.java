package com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model;

import com.touchableheroes.drafts.db.cupboard.xt.commands.cupboard.CupboardBasedInsertCommand;
import com.touchableheroes.drafts.db.cupboard.xt.commands.raw.RawQueryQueryCommand;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.DbContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.InsertContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.QueryContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.UriMatcherContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.UriOperation;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity.GameEntity;

@DbContract(
        name = "com.touchableheroes.drafts.examples.step2",
        version = 1,
        entities = {String.class})
public enum ContentProviderApiContract {

    @UriMatcherContract(
            operations = @UriOperation(
                    insert = @InsertContract(
                            entity = GameEntity.class,
                            command = CupboardBasedInsertCommand.class
                    ),
                    query = @QueryContract(
                            command = RawQueryQueryCommand.class,
                            sql = "SELECT * FROM ExampleEntity"
                    )
            )
    )
    All_GAMEZ

}