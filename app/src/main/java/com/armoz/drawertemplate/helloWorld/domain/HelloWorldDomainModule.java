package com.armoz.drawertemplate.helloWorld.domain;

import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorld;
import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorldValidator;
import com.armoz.drawertemplate.helloWorld.domain.usercase.impl.HelloWorldJob;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;

@Module(complete = false, library = true)
public class HelloWorldDomainModule {

    @Provides
    public HelloWorld provideHelloWorld(HelloWorldJob helloWorldJob) {
        return helloWorldJob;
    }

    @Provides
    public HelloWorldValidator provideHelloWorldValidator (Bus bus){
        return new HelloWorldValidator(bus);
    }
}
