package com.armoz.drawertemplate.base.application;

import android.app.Application;

import com.armoz.drawertemplate.base.domain.GlobalDomainModule;
import com.armoz.drawertemplate.base.utils.module.AndroidModule;
import com.armoz.drawertemplate.helloWorld.datasource.HelloWorldDataSourceModule;
import com.armoz.drawertemplate.helloWorld.domain.HelloWorldDomainModule;
import com.armoz.drawertemplate.helloWorld.view.HelloWorldViewModule;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.answers.Answers;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import io.fabric.sdk.android.Fabric;
import java.util.Arrays;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by ruben.arana on 23/11/15.
 */
public class BaseApplication extends Application {
    private ObjectGraph graph;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Answers(), new Crashlytics(), new CrashlyticsNdk());

        graph = ObjectGraph.create(getModules().toArray());
        graph.injectStatics();
    }

    public void inject(Object object) {
        graph.inject(object);
    }

    protected List<Object> getModules() {
        return Arrays.asList(
                new AndroidModule(this),
                new GlobalDomainModule(),
                new HelloWorldViewModule(),
                new HelloWorldDomainModule(),
                new HelloWorldDataSourceModule());
    }
}
