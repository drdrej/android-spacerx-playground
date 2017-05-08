package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.touchableheroes.drafts.db.cupboard.xt.util.ContractUriUtil;
import com.touchableheroes.drafts.spacerx.action.impl.RemoveValue;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.Step2AppStateKey;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.provider.ContentProviderApiContract;
import com.touchableheroes.drafts.spacerx.ui.DialogUtil;
import com.touchableheroes.drafts.spacerx.ui.binding.ActivityBinder;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIAction;

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

                                DialogUtil.create(
                                        AddGameDialogBinder.class,
                                        Step2StartActivity.this
                                ).title( "Test Dialog" )
                                 .view(R.layout.dialog_game_new)
                                 .show();;
                            }
                        });



                bind(R.id.input_btn_delete_all_games)
                        .click(new UIAction() {
                            @Override
                            public void action(View view) {
                                final Uri uri = ContractUriUtil.createDelete(ContentProviderApiContract.All_GAMEZ);
                                final int deleted = getContentResolver().delete(uri, null, null);
                                System.err.println(">>> deleted elements: " + deleted);

                                syntheticDom()
                                        .actions()
                                        .exec(new RemoveValue(Step2AppStateKey.GAMEZ));
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

