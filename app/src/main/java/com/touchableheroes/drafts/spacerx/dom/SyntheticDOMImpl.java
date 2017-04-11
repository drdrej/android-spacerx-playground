package com.touchableheroes.drafts.spacerx.dom;

import com.touchableheroes.drafts.spacerx.dom.values.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asiebert on 08.04.2017.
 */
public class SyntheticDOMImpl
        implements SyntheticDOM, DOMChangeListener {

    private final DOM dom;

    private ActionExecuter executer;

    private final List<UIUpdaterListener> listeners = new ArrayList<>(3);

    private Map<Enum, Getter> getter = new HashMap<>(4);

    public SyntheticDOMImpl(final DOM dom) {
        this.dom = dom;
        this.executer = new ActionExecuter(dom);

        this.dom.addChangeListener( this );
    }

    @Override
    public DOM dom() {
        return dom;
    }

    @Override
    public ActionExecuter actions() {
        return this.executer;
    }

    @Override
    public <T extends Serializable> void register(final Enum key,
                                                  final Getter<T> getter) {
        this.getter.put( key, getter );
    }

    @Override
    public void addChangeListener(UIUpdaterListener listener) {
        this.listeners.add( listener );
    }

    @Override
    public <V> V get(final Enum key) {
        if( this.getter.containsKey( key ) ) {
            final Getter getter = this.getter.get(key);
            if( getter != null ) {
                return (V) getter.get();
            } else {
                return null;
            }
        }

        return (V) dom().get(key);
    }

    @Override
    public void unbind() {
        this.listeners.clear();;
        this.getter.clear();

        dom.removeListener( this );
    }

    @Override
    public void changed(final Map<Enum, Serializable> changedMap) {
        for( final UIUpdaterListener listener :  this.listeners ) {
            listener.changed( changedMap );
        }
    }

}
