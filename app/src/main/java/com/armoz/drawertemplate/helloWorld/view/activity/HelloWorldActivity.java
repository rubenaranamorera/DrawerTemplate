package com.armoz.drawertemplate.helloWorld.view.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.EditText;
import android.widget.TextView;

import com.armoz.drawertemplate.R;
import com.armoz.drawertemplate.base.domain.events.ErrorEvent;
import com.armoz.drawertemplate.base.view.activity.BaseDrawerActivity;
import com.armoz.drawertemplate.helloWorld.view.controller.HelloWorldController;
import com.armoz.drawertemplate.helloWorld.view.model.HelloWorldViewModel;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;


public class HelloWorldActivity extends BaseDrawerActivity {

    @Inject
    Bus bus;

    @Inject
    HelloWorldController controller;

    @Bind(R.id.tv_hello_name)
    TextView helloNameTV;

    @Bind(R.id.et_name)
    EditText nameET;

    @Bind(R.id.fab)
    FloatingActionButton fab;


    private int VIEW = R.layout.activity_hello_world;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getString(R.string.hello_world_title));
        injectButterknife();
        controller.setActivity(this);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
    }

    @OnClick(R.id.fab)
    public void onFabClicked(){
        controller.getViewModel().setName(nameET.getText().toString());
        controller.saveName(controller.getViewModel());
    }

    @Override
    protected boolean showError(ErrorEvent event) {
        return false;
    }

    @Override
    public int getContentViewDrawer() {
        return VIEW;
    }


    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    public void onPause() {
        bus.unregister(this);
        super.onPause();
    }

    public void onSaveNameCompleted(HelloWorldViewModel helloWorldViewModel){
        helloNameTV.setText("HELLO " + helloWorldViewModel.getUpperName());
    }

    @Override
    public void onError(ErrorEvent event) {

    }
}
