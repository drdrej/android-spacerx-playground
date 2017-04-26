package com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model;

import com.touchableheroes.drafts.db.cupboard.xt.contracts.CupboardContract;

import com.touchableheroes.drafts.db.cupboard.xt.contracts.UriMatcherContract;
import com.touchableheroes.drafts.spacerx.spacerx.examples.step2.model.entity.GameEntity;

@CupboardContract(
        authority = "com.touchableheroes.drafts.examples.step2",
        entities = {String.class})
public enum LoaderIDs {

    @UriMatcherContract(
            type= GameEntity.class,
            path = "/games" ) // /#
    All_GAMEZ

    /*

    example:
    @CupboardLoaderContract(
            type= CurrentTrack.class,
            path = "/tracks/#" )
    CURRENT_TRACK,

    @CupboardLoaderContract(
            type = TrackEntity.class,
            path = "/tracks" )
    ALL_TRACKS

*/

}