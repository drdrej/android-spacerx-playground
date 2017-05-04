package com.touchableheroes.drafts.spacerx.spacerx.examples.step2.actions;

import com.touchableheroes.drafts.spacerx.action.Dependenicies;
import com.touchableheroes.drafts.spacerx.action.StateAction;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.Step2AppStateKey;
import com.touchableheroes.drafts.spacerx.tx.StateTX;

import java.io.Serializable;

/**
 * Created by asiebert on 07.04.2017.
 */

public class SetValueStateAction
       implements StateAction {

    private final Enum key;
    private final Serializable value;

    public SetValueStateAction(final Enum key,
                               final Serializable value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void register(final Dependenicies needs) {
        // needs.state( Step2AppStateKey.COUNTER );
    }

    @Override
    public void exec(final StateTX tx) {
        tx.change(key, value);
    }
}
