package com.touchableheroes.drafts.spacerx.spacerx.examples.step1;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.touchableheroes.drafts.spacerx.spacerx.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ContentFragment extends Fragment {

    public ContentFragment() { }

    private ExampleFragmentBinder binder = new ExampleFragmentBinder(this);

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);
        binder.init( context );
    }

    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            final ViewGroup container,
            final Bundle savedInstanceState) {
        return inflater.inflate(
                R.layout.fragment_test,
                container, false);
    }

    @Override
    public void onViewCreated(
            final View view,
            final @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binder.bind();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        binder.destroy();
    }

}
