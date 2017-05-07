package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.content.ContentValues;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.touchableheroes.drafts.db.cupboard.xt.util.ContentValuesUtil;
import com.touchableheroes.drafts.db.cupboard.xt.util.ContractUriUtil;
import com.touchableheroes.drafts.spacerx.action.AbstractStateAction;
import com.touchableheroes.drafts.spacerx.action.impl.IncValueStateAction;
import com.touchableheroes.drafts.spacerx.dom.SyntheticDOM;
import com.touchableheroes.drafts.spacerx.dom.values.Getter;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.Step2AppStateKey;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.dummy.DummyContent;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.ContentProviderApiContract;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity.GameEntity;
import com.touchableheroes.drafts.spacerx.tx.StateTX;
import com.touchableheroes.drafts.spacerx.ui.ActivityBinder;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.ui.UIAction;
import com.touchableheroes.drafts.spacerx.ui.UIUpdater;

import java.io.Serializable;
import java.util.List;

public class Step2StartActivity extends AppCompatActivity {

    private ActivityBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_example_step2);

        binder = new ActivityBinder(this) {

            @Override
            public void bind() {
                /*
                getter(ExampleAppStateKey.FORMATTED_COUNTER,
                        new Getter<String>( syntheticDom() ) {

                            public String get() {
                                final Serializable realVal = syntheticDom().get(ExampleAppStateKey.COUNTER);
                                return String.valueOf( realVal );
                            }
                        });
                */

                /*
                bind(R.id.ExampleTextView)
                        .value( ExampleAppStateKey.FORMATTED_COUNTER )
                        .updater( new UIUpdater.TextViewUIUpdater() );
                */

                bind(R.id.btn_add_game)
                        .click( new UIAction() {

                            @Override
                            public void action( final View view ) {
                                System.err.println( "Add Game !" );

                                final Uri insertUri = ContractUriUtil.createInsert(ContentProviderApiContract.All_GAMEZ);

                                final GameEntity entity = new GameEntity();
                                entity._id = System.currentTimeMillis();
                                entity.name = "TEST_ENTRY";

                                final ContentValues xyz = ContentValuesUtil.entityToContentValues( entity );
                                final Uri insertedUri = getContentResolver().insert(insertUri, xyz);

                                System.err.println( ">>> inserted uri: " + insertedUri );

                                syntheticDom().actions().exec(new AbstractStateAction() {

                                    @Override
                                    public void exec(StateTX tx) {
                                        tx.remove(Step2AppStateKey.GAMEZ);
                                    }

                                });
                            }
                        });
            }
        };

        binder.bind();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        binder.destroy();
    }
}


/*
// TODO: Click auf den Button führt zum Fehler:
FATAL EXCEPTION: main
        Process: com.touchableheroes.drafts.spacerx.spacerx, PID: 18055
        java.lang.IllegalArgumentException: Unknown URL content://com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.ContentProviderApiContract/All_GAMEZ
        at android.content.ContentResolver.insert(ContentResolver.java:1203)
        at com.touchableheroes.drafts.spacerx.spacerx.examples.step2.Step2StartActivity$1$1.action(Step2StartActivity.java:65)
        at com.touchableheroes.drafts.spacerx.ui.ViewBinding$1.onClick(ViewBinding.java:35)
        at android.view.View.performClick(View.java:4780)
        at android.view.View$PerformClick.run(View.java:19866)
        at android.os.Handler.handleCallback(Handler.java:739)
        at android.os.Handler.dispatchMessage(Handler.java:95)
        at android.os.Looper.loop(Looper.java:135)
        at android.app.ActivityThread.main(ActivityThread.java:5254)
        at java.lang.reflect.Method.invoke(Native Method)
        at java.lang.reflect.Method.invoke(Method.java:372)
        at com.android.internal.os.ZygoteInit$MethodAndArgsCaller.run(ZygoteInit.java:903)
        at com.android.internal.os.ZygoteInit.main(ZygoteInit.java:698)

*/