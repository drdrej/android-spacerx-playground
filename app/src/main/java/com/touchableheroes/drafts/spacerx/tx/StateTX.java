package com.touchableheroes.drafts.spacerx.tx;

import com.touchableheroes.drafts.spacerx.dom.DOM;
import com.touchableheroes.drafts.spacerx.state.State;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by asiebert on 07.04.2017.
 */

public class StateTX {

    private final DOM dom;

    private Map<Enum, Serializable> changed = new HashMap<Enum, Serializable>();

    public StateTX(final DOM dom) {
        this.dom = dom;
    }


    public State get(Enum key) {
        return new State(dom, key);
    }

    public void change(final Enum key, final Serializable obj) {
        if( changed.containsKey(key) ) {
            throw new IllegalStateException( "This key [=" + key + "] changed allready.");
        }

        changed.put(key, obj);
    }

    public <R extends Serializable> R value(final Enum key) {
        if( changed.containsKey(key) ) {
            return (R) changed.get(key);
        }

        return  (R) dom.get(key);
    }

    public Map<Enum, Serializable> getChanged() {
        return Collections.unmodifiableMap(changed);
    }

    public String getId() {
        return "StateTX.getId() !impl!";
    }
}
