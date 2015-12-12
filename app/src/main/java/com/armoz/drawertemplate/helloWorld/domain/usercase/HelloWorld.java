package com.armoz.drawertemplate.helloWorld.domain.usercase;


import com.armoz.drawertemplate.helloWorld.domain.callback.HelloWorldCallback;
import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;

public interface HelloWorld {

	void saveName(HelloWorldDomainModel helloWorldDomainModel, HelloWorldCallback callback);

}
