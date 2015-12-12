package com.armoz.drawertemplate.base.view.errors;


import com.armoz.drawertemplate.base.domain.events.ErrorEvent;

/**
 * Created by ruben.arana on 23/11/15.
 */
public interface ViewErrorEvent
{
    void onError(ErrorEvent event);
}
