package com.armoz.drawertemplate.helloWorld.view.controller;

import com.armoz.drawertemplate.helloWorld.domain.callback.HelloWorldCallback;
import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;
import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorld;
import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorldValidator;
import com.armoz.drawertemplate.helloWorld.view.mapper.HelloWorldMapper;
import com.armoz.drawertemplate.helloWorld.view.model.HelloWorldViewModel;

import javax.inject.Inject;

/**
 * Created by ruben.arana on 23/11/15.
 */
public class HelloWorldController {

    private View view;

    public void setView(View view) {
        this.view = view;
    }

    private HelloWorld helloWorldJob;

    private HelloWorldViewModel viewModel = new HelloWorldViewModel();
    private HelloWorldDomainModel model = new HelloWorldDomainModel();

    private HelloWorldMapper helloWorldMapper;

    private HelloWorldValidator helloWorldValidator;


    @Inject
    public HelloWorldController(HelloWorld helloWorldJob, HelloWorldMapper helloWorldMapper, HelloWorldValidator helloWorldValidator) {
        this.helloWorldJob = helloWorldJob;
        this.helloWorldMapper = helloWorldMapper;
        this.helloWorldValidator = helloWorldValidator;
    }

    public HelloWorldViewModel getViewModel() {
        return viewModel;
    }

    public void saveName(HelloWorldViewModel helloWorldViewModel) {

        model.setName(helloWorldViewModel.getName());

        if (helloWorldValidator.isValidHelloWorld(model)) {
            helloWorldJob.saveName(model, helloWorldCallback);

        } else {
            view.onError();
        }
    }

    private HelloWorldCallback helloWorldCallback = new HelloWorldCallback() {
        @Override
        public void onSaveNameCompleted(HelloWorldDomainModel helloWorldDomainModel) {
            viewModel = helloWorldMapper.convert(helloWorldDomainModel);
            view.onSaveNameCompleted(viewModel);
        }

        @Override
        public void onError() {
            view.onError();
        }

    };


    public interface View {

        public void onSaveNameCompleted(HelloWorldViewModel helloWorldViewModel);

        public void onError();

    }

}
