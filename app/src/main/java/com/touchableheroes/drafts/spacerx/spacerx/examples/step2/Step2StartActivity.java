package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.app.Dialog;
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
import com.touchableheroes.drafts.spacerx.ui.binding.ActivityBinder;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIAction;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIUpdater;

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
                bind(R.id.btn_add_game)
                        .click( new UIAction() {

                            @Override
                            public void action( final View view ) {
                                System.err.println( "Add Game !" );

                                DialogUtil.create( Step2StartActivity.this )
                                        .title( "Test Dialog" )
                                        .view(R.layout.dialog_game_new)
                                .show();
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

