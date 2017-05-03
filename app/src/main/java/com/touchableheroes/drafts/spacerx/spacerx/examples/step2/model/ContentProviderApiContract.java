package com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model;

import com.touchableheroes.drafts.db.cupboard.xt.commands.cupboard.CupboardBasedInsertCommand;
import com.touchableheroes.drafts.db.cupboard.xt.commands.cupboard.CupboardBasedQueryQueryCommand;
import com.touchableheroes.drafts.db.cupboard.xt.commands.raw.RawQueryQueryCommand;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.DbContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.InsertContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.QueryContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.UriMatcherContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.UriOperation;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity.GameEntity;

@DbContract(
        name = "com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.ContentProviderApiContract",
        version = 1,
        entities = {GameEntity.class})
public enum ContentProviderApiContract {

    @UriMatcherContract(
            operations = @UriOperation(
                    insert = @InsertContract(
                            entity = GameEntity.class,
                            command = CupboardBasedInsertCommand.class
                    ),
                    query = @QueryContract(
                            command = CupboardBasedQueryQueryCommand.class,
                            entity = GameEntity.class
                    )
            )
    )
    All_GAMEZ

}