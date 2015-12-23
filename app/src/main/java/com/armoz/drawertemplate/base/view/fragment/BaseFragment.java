package com.armoz.drawertemplate.base.view.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.armoz.drawertemplate.base.domain.events.ErrorEvent;
import com.armoz.drawertemplate.base.view.activity.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by ruben.arana on 23/11/15.
 */
public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((BaseActivity) this.getActivity()).inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    public abstract boolean showError(ErrorEvent event);

    @Override
    public void onResume() {
        super.onResume();
    }

}
