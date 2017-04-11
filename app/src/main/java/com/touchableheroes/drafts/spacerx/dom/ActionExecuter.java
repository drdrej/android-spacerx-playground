package com.touchableheroes.drafts.spacerx.dom;

import android.util.Log;

import com.touchableheroes.drafts.spacerx.action.StateAction;
import com.touchableheroes.drafts.spacerx.tx.StateTX;

/**
 * Created by asiebert on 08.04.2017.
 */

public class ActionExecuter {

    private final DOM src;

    public ActionExecuter(DOM src) {
      this.src = src;
    }

    public void exec(StateAction action) {
        final StateTX tx = src.transaction( );

        try {
            action.exec(tx);
        } catch ( Throwable x ) {
            Log.e("TODO", "Add logging" );
            x.printStackTrace();

            src.rollback(tx);
            return;
        }

        // TODO: was machen, wenn commit fehl schlaegt?
        src.commit(tx);
    }

}
