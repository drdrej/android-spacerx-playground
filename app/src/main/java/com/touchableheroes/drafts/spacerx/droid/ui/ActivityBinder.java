package com.touchableheroes.drafts.spacerx.droid.ui;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/**
 * Created by asiebert on 12.04.2017.
 */

public class ActivityBinder extends AbstractUIBinder {

    private final Activity activity;

    public ActivityBinder(final Activity activity) {
        this.activity = activity;
    }

    @Override
    protected View view() {
        return activity.findViewById(android.R.id.content);
    }

    @Override
    public void bind() {

    }

    @Override
    public void init(Context ctx) {

    }

}
