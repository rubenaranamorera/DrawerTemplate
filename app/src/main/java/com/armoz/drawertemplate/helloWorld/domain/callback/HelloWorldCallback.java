package com.armoz.drawertemplate.helloWorld.domain.callback;


import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;

/**
 *
 */
public interface HelloWorldCallback {

    void onSaveNameCompleted(HelloWorldDomainModel helloWorldDomainModel);

    void onError();
}
