package com.armoz.drawertemplate.helloWorld.domain.usercase.impl;

import com.armoz.drawertemplate.base.domain.DomainErrorHandler;
import com.armoz.drawertemplate.base.domain.interactor.MainThread;
import com.armoz.drawertemplate.base.domain.interactor.impl.UserCaseJob;
import com.armoz.drawertemplate.helloWorld.datasource.HelloWorldDataSource;
import com.armoz.drawertemplate.helloWorld.domain.callback.HelloWorldCallback;
import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;
import com.armoz.drawertemplate.helloWorld.domain.usercase.HelloWorld;
import com.path.android.jobqueue.JobManager;
import com.path.android.jobqueue.Params;

import javax.inject.Inject;

;

public class HelloWorldJob extends UserCaseJob implements HelloWorld {

    private HelloWorldCallback callback;
    private HelloWorldDataSource helloWorldDataSource;
    private HelloWorldDomainModel helloWorldDomainModel;


    @Inject
    HelloWorldJob(JobManager jobManager, MainThread mainThread,
                  DomainErrorHandler domainErrorHandler, HelloWorldDataSource helloWorldDataSource
    ) {
        super(jobManager, mainThread, new Params(UserCaseJob.DEFAULT_PRIORITY), domainErrorHandler);
        this.helloWorldDataSource = helloWorldDataSource;
    }

    @Override
    public void saveName(HelloWorldDomainModel helloWorldDomainModel, HelloWorldCallback callback) {
        this.callback = callback;
        this.helloWorldDomainModel = helloWorldDomainModel;
        jobManager.addJob(this);
    }

    @Override
    public void doRun() throws Throwable {
        try {
            HelloWorldDomainModel response = helloWorldDataSource.saveName(helloWorldDomainModel);
            onSaveNameCompleted(response);
        }
        catch (Exception e){
            notifyError();
        }
    }

    private void notifyError() {
        sendCallback(new Runnable() {
            @Override
            public void run() {
                if (callback != null) {
                    callback.onError();
                }
            }
        });
    }

    private void onSaveNameCompleted(final HelloWorldDomainModel helloWorldDomainModel) {
        sendCallback(new Runnable() {
            @Override
            public void run() {
                callback.onSaveNameCompleted(helloWorldDomainModel);
            }
        });
    }
}
