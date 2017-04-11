package com.touchableheroes.drafts.spacerx.spacerx;

import com.touchableheroes.drafts.spacerx.action.Dependenicies;
import com.touchableheroes.drafts.spacerx.action.StateAction;
import com.touchableheroes.drafts.spacerx.state.Condition;
import com.touchableheroes.drafts.spacerx.state.State;
import com.touchableheroes.drafts.spacerx.tx.StateTX;

/**
 * Created by asiebert on 07.04.2017.
 */

public class ExampleStateAction implements StateAction {

    @Override
    public void register(Dependenicies needs) {
        needs.state( ExampleAppStateKey.COUNTER );
    }

    @Override
    public void exec(StateTX tx) {
/*        State state = tx.get( ExampleAppStateKey.USERS );

        state.when(
                new Condition() {

          }
        );
*/


        int val = (int) tx.value(ExampleAppStateKey.USERS);

        tx.change( ExampleAppStateKey.COUNTER, 1 );

        // tx.cancel( "...." );

        //state.when().then();
        //.isType()
              //  .then(new Then<String>() {
              //      public void handle( ) {

              //      }
              //  });
    }
}
