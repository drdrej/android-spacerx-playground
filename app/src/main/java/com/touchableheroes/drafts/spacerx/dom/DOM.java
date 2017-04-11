package com.touchableheroes.drafts.spacerx.dom;

import com.touchableheroes.drafts.spacerx.state.State;
import com.touchableheroes.drafts.spacerx.tx.StateTX;

import java.io.Serializable;

/**
 * Created by asiebert on 08.04.2017.
 */

public interface DOM {

    public void init();

    public StateTX transaction(final Enum... values);

    public void commit(final StateTX tx);

    public <T extends Serializable> T get(final Enum key);

    public String rollback(final StateTX tx);

    public void addChangeListener(final DOMChangeListener listener);

    public void removeListener(final DOMChangeListener listener);

}
