package com.armoz.drawertemplate.helloWorld.domain;

import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorld;
import com.armoz.drawertemplate.helloWorld.domain.usercase.impl.HelloWorldJob;

import dagger.Module;
import dagger.Provides;

@Module(complete = false, library = true)
public class HelloWorldDomainModule {

	@Provides
	public HelloWorld provideHelloWorld(HelloWorldJob helloWorldJob) {
		return helloWorldJob;
	}
}
