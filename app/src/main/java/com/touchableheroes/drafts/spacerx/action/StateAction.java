package com.touchableheroes.drafts.spacerx.action;

import com.touchableheroes.drafts.spacerx.tx.StateTX;

import java.io.Serializable;

/**
 * Created by asiebert on 07.04.2017.
 */

public interface StateAction extends Serializable {

    public void register( Dependenicies dependenicies);

    public void exec(StateTX tx);
}
