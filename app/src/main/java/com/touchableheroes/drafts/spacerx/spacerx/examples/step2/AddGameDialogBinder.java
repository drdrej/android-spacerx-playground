package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.app.Dialog;
import android.content.ContentValues;
import android.net.Uri;
import android.view.View;

import com.touchableheroes.drafts.db.cupboard.xt.util.ContentValuesUtil;
import com.touchableheroes.drafts.db.cupboard.xt.util.ContractUriUtil;
import com.touchableheroes.drafts.spacerx.action.AbstractStateAction;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.Step2AppStateKey;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.ContentProviderApiContract;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity.GameEntity;
import com.touchableheroes.drafts.spacerx.tx.StateTX;
import com.touchableheroes.drafts.spacerx.ui.binding.DialogBinder;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIAction;

/**
 * Created by asiebert on 08.05.2017.
 */

public class AddGameDialogBinder extends DialogBinder {
    public AddGameDialogBinder(Dialog dialog) {
        super(dialog);
    }

    @Override
    protected View view() {
        return dialog().findViewById( R.id.root_dialog );
    }

    @Override
    public void bind() {
        bind(R.id.input_btn_ok)
                .click(new UIAction() {

                    @Override
                    public void action(final View view) {
                        System.err.println( ">>> " + view );

                        final Uri insertUri = ContractUriUtil.createInsert(ContentProviderApiContract.All_GAMEZ);

                        final GameEntity entity = new GameEntity();
                        entity._id = System.currentTimeMillis();
                        entity.name = "TEST_ENTRY";

                        final ContentValues xyz = ContentValuesUtil.entityToContentValues( entity );
                        final Uri insertedUri = dialog().getContext().getContentResolver().insert(insertUri, xyz);

                        syntheticDom().actions().exec(new AbstractStateAction() {

                            @Override
                            public void exec(StateTX tx) {
                                tx.remove(Step2AppStateKey.GAMEZ);
                            }

                        });

                        dialog().dismiss();
                    }
                });

    }

}
