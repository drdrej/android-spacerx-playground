package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.app.Dialog;
import android.content.Context;

/**
 * Created by asiebert on 08.05.2017.
 */

public class DialogUtil {

    public static class DialogBuilder {

        private final Dialog dialog;

        public DialogBuilder(final Context ctx) {
            dialog = new Dialog(ctx);
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
