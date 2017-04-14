package com.touchableheroes.drafts.spacerx.spacerx.examples.step2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.touchableheroes.drafts.spacerx.ui.ActivityBinder;
import com.touchableheroes.drafts.spacerx.spacerx.R;

public class StartActivity extends AppCompatActivity {

    private ActivityBinder binder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_example_step2);

        binder = new ActivityBinder(this);
        binder.bind();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        binder.destroy();
    }
}
