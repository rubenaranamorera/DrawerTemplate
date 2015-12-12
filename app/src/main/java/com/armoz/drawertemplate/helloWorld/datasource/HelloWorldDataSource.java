package com.armoz.drawertemplate.helloWorld.datasource;

import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;

/**
 * Created by ruben.arana on 23/11/15.
 */
public interface HelloWorldDataSource {
    HelloWorldDomainModel saveName(HelloWorldDomainModel helloWorldDomainModel);
}
