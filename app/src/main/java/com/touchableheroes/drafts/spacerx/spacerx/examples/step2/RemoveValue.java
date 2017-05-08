package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import com.touchableheroes.drafts.core.logger.Fact;
import com.touchableheroes.drafts.core.logger.Tracer;
import com.touchableheroes.drafts.core.tools.ArrayTool;
import com.touchableheroes.drafts.spacerx.action.AbstractStateAction;
import com.touchableheroes.drafts.spacerx.action.StateAction;
import com.touchableheroes.drafts.spacerx.tx.StateTX;

/**
 * Created by asiebert on 08.05.2017.
 */

public class RemoveValue extends  AbstractStateAction {

    private final Enum[] keys;

    public RemoveValue(final Enum... keys) {
        Tracer.prove(new Fact() {

            @Override
            public void check() {
                if( ArrayTool.isEmpty(keys) ) {
                    throw new IllegalArgumentException( "param:keys; Passed Array should be not empty!" );
                }
            }
        });

        this.keys = keys;
    }

    @Override
    public void exec(final StateTX tx) {
        super.exec(tx);

        for ( final Enum key: keys ) {
            tx.remove(key);
        }
    }

}
