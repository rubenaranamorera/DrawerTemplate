package com.armoz.drawertemplate.helloWorld.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.armoz.drawertemplate.R;
import com.armoz.drawertemplate.base.domain.events.ErrorEvent;
import com.armoz.drawertemplate.base.view.activity.BaseTabbedActivity;
import com.armoz.drawertemplate.helloWorld.view.fragment.HelloWorldFragment;


public class HelloWorldActivity extends BaseTabbedActivity {

    private HelloWorldFragment helloWorldFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.hello_world_title));

        //For a BaseDrawerActivity
        /*if (savedInstanceState == null){
            helloWorldFragment = new HelloWorldFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, helloWorldFragment).commit();
        }*/
    }


    @Override
    protected int getTabsNumber() {
        return 2;
    }

    @Override
    protected Fragment getTab(int position) {

        switch (position) {
            case 0:
                return new HelloWorldFragment();
            case 1:
                return new HelloWorldFragment();
            default:
                return new HelloWorldFragment();
        }

    }

    @Override
    protected CharSequence getTabTitle(int position) {
        switch (position) {
            case 0:
                return "Tit1";
            case 1:
                return "Tit2";
            default:
                return "Tit empty";
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
