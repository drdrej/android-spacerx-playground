package com.touchableheroes.drafts.spacerx.action.impl;

import com.touchableheroes.drafts.spacerx.action.AbstractStateAction;
import com.touchableheroes.drafts.spacerx.tx.StateTX;

import java.io.Serializable;

/**
 * Created by asiebert on 08.04.2017.
 */

public class IncValueStateAction extends AbstractStateAction {

    private final Enum key;

    public IncValueStateAction(Enum key) {
        this.key = key;
    }

    @Override
    public void exec(final StateTX tx) {
        final Serializable val = tx.value(key);
        final int number = (val == null) ? 0 : (int) val;
        System.out.println( "Changed Value COUNZTEr: " + val);
        final int newVal = (number + 1);
        tx.change(key, newVal);
    }
}
