package com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.provider;

import com.touchableheroes.drafts.db.cupboard.xt.commands.cupboard.CupboardBasedDeleteCommand;
import com.touchableheroes.drafts.db.cupboard.xt.commands.cupboard.CupboardBasedInsertCommand;
import com.touchableheroes.drafts.db.cupboard.xt.commands.cupboard.CupboardBasedQueryQueryCommand;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.DbContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.DeleteContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.InsertContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.QueryContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.UriMatcherContract;
import com.touchableheroes.drafts.db.cupboard.xt.contracts.UriOperation;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.entities.GameEntity;

@DbContract(
        name = "com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.provider.ContentProviderApiContract",
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
                    ),
                    delete = @DeleteContract(
                            entity = GameEntity.class,
                            command = CupboardBasedDeleteCommand.class
                    )
            )
    )
    All_GAMEZ,

    @UriMatcherContract(
            operations = @UriOperation(
                    delete = @DeleteContract(
                            entity = GameEntity.class,
                            command = CupboardBasedDeleteCommand.class,
                            selection = "_id = ?" // better named ?ID
                    )
            )
    )
    DEL_GAME_BY_ID
}