package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.touchableheroes.drafts.db.cupboard.xt.util.ContentValuesUtil;
import com.touchableheroes.drafts.db.cupboard.xt.util.ContractUriUtil;
import com.touchableheroes.drafts.spacerx.action.AbstractStateAction;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.Step2AppStateKey;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.ContentProviderApiContract;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity.GameEntity;
import com.touchableheroes.drafts.spacerx.tx.StateTX;
import com.touchableheroes.drafts.spacerx.ui.binding.AbstractUIBinder;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIAction;

/**
 * Created by asiebert on 08.05.2017.
 */

public class DialogUtil {


    public static class DialogBinder
            extends AbstractUIBinder{

        private final Dialog dialog;

        public DialogBinder(final Dialog dialog ) {
            this.dialog = dialog;
        }
        
        @Override
        protected View view() {
            return dialog.findViewById( R.id.root_dialog );
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
                    final Uri insertedUri = dialog.getContext().getContentResolver().insert(insertUri, xyz);

                    syntheticDom().actions().exec(new AbstractStateAction() {

                        @Override
                        public void exec(StateTX tx) {
                            tx.remove(Step2AppStateKey.GAMEZ);
                        }

                    });

                    dialog.dismiss();
                }
            });


        }

        @Override
        public void init(Context context) {
            ;
        }

    }


    public static class DialogBuilder {

        private final Dialog dialog;

        public DialogBuilder(final Context ctx) {
            dialog = new Dialog(ctx) {

                public DialogBinder dialog;

                @Override
                protected void onCreate(
                        final Bundle savedInstanceState) {

                    super.onCreate(savedInstanceState);
                }

                @Override
                protected void onStart() {
                    super.onStart();

                    this.dialog = new DialogBinder(this);
                    this.dialog.bind();
                }

                @Override
                protected void onStop() {
                    super.onStop();

                    this.dialog.destroy();
                }
            };
        }

        public DialogBuilder title(final String title) {
            dialog.setTitle( title );
            return this;
        }

        public DialogBuilder view(final int layoutId) {
            dialog.setContentView( layoutId );
            return this;
        }

        public DialogBuilder show() {
            dialog.show();

            return this;
        }

        public DialogBuilder on() {
            // final EditText txt = (EditText) dialog.findViewById(R.id.input_txt_game_name);

            /*
            final Button dialogButton = (Button) dialog.findViewById(R.id.input_btn_ok);

            dialogButton.setOnClickListener(
                    new View.OnClickListener() {

                @Override
                public void onClick(final View view) {
                    final String text = txt.getText().toString();

                    dialog.dismiss();
                }
            });
            */

            return this;
        }
    }

    public static DialogBuilder create(final Context ctx) {
        return new DialogBuilder(ctx);

               /*
        dialogR.layout.custom);

        // set the custom dialog components - text, image and button
        TextView text = (TextView) dialog.findViewById(R.id.text);
        text.setText("Android custom dialog example!");
        ImageView image = (ImageView) dialog.findViewById(R.id.image);
        image.setImageResource(R.drawable.ic_launcher);

        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        // dialog.show();
        */
    }
}
