package com.armoz.drawertemplate.helloWorld.view.controller;

import android.view.View;

import com.armoz.drawertemplate.helloWorld.domain.callback.HelloWorldCallback;
import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;
import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorld;
import com.armoz.drawertemplate.helloWorld.view.activity.HelloWorldActivity;
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

    private HelloWorldActivity activity;

    @Inject
    public HelloWorldController(HelloWorld helloWorldJob, HelloWorldMapper helloWorldMapper){
        this.helloWorldJob = helloWorldJob;
        this.helloWorldMapper = helloWorldMapper;
    }

    public HelloWorldViewModel getViewModel() {
        return viewModel;
    }

    public void saveName(HelloWorldViewModel helloWorldViewModel){
        model.setName(helloWorldViewModel.getName());
        helloWorldJob.saveName(model, helloWorldCallback);
    }

    private HelloWorldCallback helloWorldCallback = new HelloWorldCallback() {
        @Override
        public void onSaveNameCompleted(HelloWorldDomainModel helloWorldDomainModel) {
            activity.onSaveNameCompleted(helloWorldMapper.convert(helloWorldDomainModel));
        }

    };

    public void setActivity(HelloWorldActivity helloWorldActivity) {
        this.activity = helloWorldActivity;
    }

    public interface Activity {
        void onSaveNameCompleted(HelloWorldViewModel helloWorldViewModel);
    }

}
