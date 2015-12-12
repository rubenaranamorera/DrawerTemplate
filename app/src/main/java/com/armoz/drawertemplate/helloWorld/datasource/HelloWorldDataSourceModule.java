package com.armoz.drawertemplate.helloWorld.datasource;

import com.armoz.drawertemplate.helloWorld.datasource.impl.HelloWorldDataSourceFromBBDD;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ruben.arana on 23/11/15.
 */
@Module(complete = false, library = true)
public class HelloWorldDataSourceModule {

    @Provides
    public HelloWorldDataSource providesHelloWorldDataSource(HelloWorldDataSourceFromBBDD helloWorldDataSourceFromBBDD) {
        return helloWorldDataSourceFromBBDD;
    }
}
