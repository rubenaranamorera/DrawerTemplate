package com.armoz.drawertemplate.base.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.appcompat.BuildConfig;

import com.armoz.drawertemplate.base.application.BaseApplication;
import com.armoz.drawertemplate.base.domain.events.ErrorEvent;
import com.armoz.drawertemplate.base.view.errors.ViewErrorEvent;
import com.armoz.drawertemplate.base.view.errors.ViewErrorHandler;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.ButterKnife;

abstract public class BaseActivity extends AppCompatActivity implements ViewErrorEvent {

    @Inject
    Bus bus;

    protected ViewErrorHandler viewErrorHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inject(this);
        setContentView(getContentViewBase());
    }

    protected void injectButterknife(){
        ButterKnife.setDebug(BuildConfig.DEBUG);
        ButterKnife.bind(this);
        viewErrorHandler = new ViewErrorHandler(bus, this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void inject(Object object) {
        // Perform injection so that when this call returns all dependencies will be available for use.
        ((BaseApplication) getApplication()).inject(object);
    }

    abstract public int getContentViewBase();

    protected abstract boolean showError(ErrorEvent event);

}
