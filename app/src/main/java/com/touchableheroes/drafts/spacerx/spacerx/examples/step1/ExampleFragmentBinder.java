package com.touchableheroes.drafts.spacerx.spacerx.examples.step1;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.touchableheroes.drafts.spacerx.action.impl.IncValueStateAction;
import com.touchableheroes.drafts.spacerx.dom.values.Getter;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.ui.FragmentBinder;
import com.touchableheroes.drafts.spacerx.ui.UIAction;
import com.touchableheroes.drafts.spacerx.ui.UIUpdater;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.ui.FragmentBinder;

import java.io.Serializable;

/**
 * Created by asiebert on 08.04.2017.
 */

public class ExampleFragmentBinder
        extends FragmentBinder {

    public ExampleFragmentBinder(final Fragment src) {
        super(src);
    }

    @Override
    public void bind()  {
        getter(ExampleAppStateKey.FORMATTED_COUNTER,
               new Getter<String>( syntheticDom() ) {

            public String get() {
                final Serializable realVal = syntheticDom().get(ExampleAppStateKey.COUNTER);
                return String.valueOf( realVal );
            }
        });

        bind(R.id.ExampleTextView)
                .value( ExampleAppStateKey.FORMATTED_COUNTER )
                .updater( new UIUpdater.TextViewUIUpdater() );

        bind(R.id.CounterButton)
                .click( new UIAction() {

                    @Override
                    public void action( final View view ) {
                        System.err.println( "Ausgabe!!!" );

                        final SyntheticDOM synth = syntheticDom();
                        synth.actions()
                             .exec( new IncValueStateAction(ExampleAppStateKey.COUNTER) );
                    }
                });
    }

    @Override
    public void init(final Context ctx) {
        ;
    }


    @Override
    public void destroy() {
        super.destroy();


    }
}
