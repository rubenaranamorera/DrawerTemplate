package com.armoz.drawertemplate.helloWorld.view;

/**
 * Created by ruben.arana on 23/11/15.
 */

import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorld;
import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorldValidator;
import com.armoz.drawertemplate.helloWorld.view.activity.HelloWorldActivity;
import com.armoz.drawertemplate.helloWorld.view.controller.HelloWorldController;
import com.armoz.drawertemplate.helloWorld.view.fragment.HelloWorldFragment;
import com.armoz.drawertemplate.helloWorld.view.mapper.HelloWorldMapper;

import dagger.Module;
import dagger.Provides;

/**
 *
 */
@Module(injects = {HelloWorldActivity.class, HelloWorldFragment.class}, complete = false,
        library = true)
public class HelloWorldViewModule {

    @Provides
    public HelloWorldMapper provideHelloWorldMapper() {
        return new HelloWorldMapper();
    }

    @Provides
    public HelloWorldController provideHelloWorldController(HelloWorld helloWorldJob, HelloWorldMapper helloWorldMapper, HelloWorldValidator helloWorldValidator) {
        return new HelloWorldController(helloWorldJob, helloWorldMapper, helloWorldValidator);
    }
}
