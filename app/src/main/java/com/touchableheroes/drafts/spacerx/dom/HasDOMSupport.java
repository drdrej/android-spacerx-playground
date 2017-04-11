package com.touchableheroes.drafts.spacerx.dom;

/**
 * Created by asiebert on 10.04.2017.
 */

public class HasDOMSupport {

    private static DOM DOM_INSTANCE;

    public synchronized static DOM initDOM() {
        DOM_INSTANCE = new DOMImpl();

        return DOM_INSTANCE;
    }

    /**
     *
     */
    public synchronized static DOM getDOM() {
        if( DOM_INSTANCE == null ) {
            throw new IllegalStateException( "DOM is not initialized! Need to call initDOM() before getDOM()." );
        }

        return DOM_INSTANCE;
    }

}
