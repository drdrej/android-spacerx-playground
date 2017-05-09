package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;

import com.touchableheroes.drafts.db.cupboard.xt.cursor.ConverterCursorList;
import com.touchableheroes.drafts.spacerx.dom.listener.DOMChangeListener;
import com.touchableheroes.drafts.spacerx.spacerx.R;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.Step2AppStateKey;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.projections.GameEntityProjection;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.contracts.provider.ContentProviderApiContract;
import com.touchableheroes.drafts.spacerx.tx.Remove;
import com.touchableheroes.drafts.spacerx.ui.binding.FragmentBinder;
import com.touchableheroes.drafts.spacerx.ui.binding.action.UIUpdater;

import java.io.Serializable;
import java.util.Map;

public class GameItemFragementBinder
           extends FragmentBinder {

        public GameItemFragementBinder(final Fragment src) {
            super(src);
        }

        @Override
        public void bind() {

            bind(R.id.gamez_list)
                    .value( Step2AppStateKey.GAMEZ )
                    .updater(new UIUpdater() {

                        @Override
                        public void update(final View view,
                                           final Serializable data) {
                            if( data != null
                                && !(data instanceof Remove)) {
                                ((GameItemFragment) owner()).adapter.updateData( (ConverterCursorList<GameEntityProjection>) data );
                            }
                        }
                    });

            onChange( Step2AppStateKey.GAMEZ )
                    .ifOneOf(new DOMChangeListener() {

                        @Override
                        public void changed(final Map<Enum, Serializable> map) {
                            final Serializable gamez = map.get(Step2AppStateKey.GAMEZ);

                            if( gamez instanceof Remove ) {
                                ((GameItemFragment) owner()).loaderMgr.reload( ContentProviderApiContract.All_GAMEZ );
                            }
                        }
                    });
        }

        @Override
        public void init(final Context context) {
            ;
        }
    };
