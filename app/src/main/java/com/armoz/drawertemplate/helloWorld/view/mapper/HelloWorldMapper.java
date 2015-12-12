package com.armoz.drawertemplate.helloWorld.view.mapper;

import com.armoz.drawertemplate.helloWorld.domain.model.HelloWorldDomainModel;
import com.armoz.drawertemplate.helloWorld.view.model.HelloWorldViewModel;

/**
 * Created by ruben.arana on 23/11/15.
 */
public class HelloWorldMapper {



	public HelloWorldMapper() {
	}

	public HelloWorldDomainModel convert (HelloWorldViewModel src) {
		HelloWorldDomainModel helloWorldDomainModel = new HelloWorldDomainModel();
		helloWorldDomainModel.setName(src.getName());
		return helloWorldDomainModel;
	}

	public HelloWorldViewModel convert (HelloWorldDomainModel src) {
		HelloWorldViewModel helloWorldViewModel = new HelloWorldViewModel();
		helloWorldViewModel.setName(src.getName());
		helloWorldViewModel.setUpperName(src.getName().toUpperCase());
		return helloWorldViewModel;
	}

}
