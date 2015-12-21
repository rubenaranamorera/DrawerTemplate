package com.armoz.drawertemplate.helloWorld.domain.usercase;

import com.armoz.drawertemplate.base.domain.events.GeneralErrorEvent;
import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;
import com.squareup.otto.Bus;

/**
 * Created by ruben.arana on 23/11/15.
 */
public class HelloWorldValidator {

    Bus bus;

    public HelloWorldValidator(Bus bus) {
        this.bus = bus;
    }

    public boolean isValidHelloWorld(HelloWorldDomainModel model) {

        boolean isValid = true;

        if (!model.getName().matches("[a-zA-Z]+")) {
            return post(new GeneralErrorEvent("Your name should contain only letters"));
        }
        return isValid;
    }

    private boolean post(GeneralErrorEvent generalErrorEvent) {
        bus.post(generalErrorEvent);
        return false;
    }
}
