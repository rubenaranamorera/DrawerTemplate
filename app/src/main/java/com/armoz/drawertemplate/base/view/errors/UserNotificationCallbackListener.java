package com.armoz.drawertemplate.base.view.errors;

/**
 * Created by toni on 15/09/14.
 */
public interface UserNotificationCallbackListener {
    public abstract void onUserNotificationAction(Object callbackInfo);
    public abstract void onUserNotificationClosed();
}
