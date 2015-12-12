package com.armoz.drawertemplate.helloWorld.datasource.impl;

import android.util.Log;

import com.armoz.drawertemplate.helloWorld.datasource.HelloWorldDataSource;
import com.armoz.drawertemplate.helloWorld.datasource.model.HelloWorldDDBBModel;
import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;

import javax.inject.Inject;

/**
 * Created by ruben.arana on 23/11/15.
 */
public class HelloWorldDataSourceFromBBDD implements HelloWorldDataSource {

    @Inject
    public HelloWorldDataSourceFromBBDD(){
    }

    @Override
    public HelloWorldDomainModel saveName(HelloWorldDomainModel helloWorldDomainModel) {

        HelloWorldDDBBModel helloWorldDDBBModel = convert(helloWorldDomainModel);

        Log.d("HelloWorldFromBBDD", "Saving helloWorld model");

        HelloWorldDomainModel s = convert(helloWorldDDBBModel);

        return s;


    }

    private HelloWorldDomainModel convert(HelloWorldDDBBModel helloWorldDDBBModel) {
        HelloWorldDomainModel helloWorldDomainModel = new HelloWorldDomainModel();
        helloWorldDomainModel.setName(helloWorldDDBBModel.getName());
        return helloWorldDomainModel;
    }

    private HelloWorldDDBBModel convert(HelloWorldDomainModel helloWorldDomainModel) {
        HelloWorldDDBBModel helloWorldDDBBModel = new HelloWorldDDBBModel();
        helloWorldDDBBModel.setName(helloWorldDomainModel.getName());
        helloWorldDDBBModel.setNormalizedName(helloWorldDomainModel.getName().toLowerCase());
        return helloWorldDDBBModel;
    }
}
