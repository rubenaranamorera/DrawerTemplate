package com.armoz.drawertemplate.base.view.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.armoz.drawertemplate.R;

public abstract class BaseToolbarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.frame_layout);
        LayoutInflater.from(this).inflate(getContentViewToolbar(), frameLayout, true);

        setSupportActionBar(getToolbar());
    }

    @Override
    public int getContentViewBase() {
       return R.layout.app_bar_main;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        /*if (item.getItemId() == android.R.id.home) {
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    public Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    abstract public int getContentViewToolbar() ;
}
