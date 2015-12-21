package com.armoz.drawertemplate.helloWorld.view.activity;

import android.os.Bundle;

import com.armoz.drawertemplate.R;
import com.armoz.drawertemplate.base.domain.events.ErrorEvent;
import com.armoz.drawertemplate.base.view.activity.BaseDrawerActivity;
import com.armoz.drawertemplate.helloWorld.view.fragment.HelloWorldFragment;


public class HelloWorldActivity extends BaseDrawerActivity {


    private HelloWorldFragment helloWorldFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.hello_world_title));

        if (savedInstanceState == null){
            helloWorldFragment = new HelloWorldFragment();
            getFragmentManager().beginTransaction().add(R.id.frame_layout, helloWorldFragment).commit();
        }
    }

    @Override
    protected boolean showError(ErrorEvent event) {
        if (helloWorldFragment != null) {
            return helloWorldFragment.showError(event);
        }
        return false;
    }
}
