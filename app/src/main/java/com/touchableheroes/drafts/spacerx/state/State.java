package com.touchableheroes.drafts.spacerx.state;

import com.touchableheroes.drafts.spacerx.dom.DOM;

import java.io.Serializable;

/**
 * Created by asiebert on 07.04.2017.
 */

public class State {

    private Serializable src;

    public State(DOM dom, Enum key) {

    }

    public void set( final Serializable src) {
        this.src = src;
    }

    public Then when( Condition cnd ) {
        return null;
    }


}
