package com.armoz.drawertemplate.helloWorld.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.armoz.drawertemplate.R;
import com.armoz.drawertemplate.base.domain.events.ErrorEvent;
import com.armoz.drawertemplate.base.view.fragment.BaseFragment;
import com.armoz.drawertemplate.helloWorld.view.controller.HelloWorldController;
import com.armoz.drawertemplate.helloWorld.view.model.HelloWorldViewModel;
import com.squareup.otto.Bus;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * A placeholder fragment containing a simple view.
 */
public class HelloWorldFragment extends BaseFragment implements HelloWorldController.View {

    @Inject
    HelloWorldController controller;

    @Inject
    Bus bus;

    @Bind(R.id.tv_hello_name)
    TextView helloNameTV;

    @Bind(R.id.et_name)
    EditText nameET;

    private View rootView;

    public HelloWorldFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_hello_world, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        controller.setView(this);
    }


    @Override
    public boolean showError(ErrorEvent event) {
        createSnackbarError();
        return false;
    }


    @OnClick(R.id.fab)
    public void onFabClicked() {
        controller.getViewModel().setName(nameET.getText().toString());
        controller.saveName(controller.getViewModel());
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.register(this);
    }

    @Override
    public void onPause() {
        bus.unregister(this);
        super.onPause();
    }

    public void onSaveNameCompleted(HelloWorldViewModel helloWorldViewModel) {
        helloNameTV.setText("HELLO " + helloWorldViewModel.getUpperName());
        helloNameTV.setVisibility(View.VISIBLE);
    }

    @Override
    public void onError() {
        createSnackbarError();
        helloNameTV.setVisibility(View.GONE);
    }


    private void createSnackbarError() {
        Snackbar snackbar = Snackbar.make(
                rootView,
                "Error message",
                Snackbar.LENGTH_LONG);

        //No action created
        snackbar.setAction("Action", null);
        snackbar.getView().setBackgroundColor(Color.RED);

        TextView textView = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);

        snackbar.show();
    }
}
