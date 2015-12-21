package com.armoz.drawertemplate.base.view.errors;

import de.keyboardsurfer.android.widget.crouton.Configuration;

/**
 * Plain object for holding a Notification
 */
public class UserNotification {

	private String message;
	private Type type = Type.ERROR; // To avoid null errors
	private UserNotificationCallbackListener listener;
	private int duration = Configuration.DURATION_LONG;

	public enum Type {
		INFO,
		ERROR,
        WARN,
		GOODNEWS
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserNotificationCallbackListener getListener() {
		return listener;
	}

	public void setListener(UserNotificationCallbackListener listener) {
		this.listener = listener;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
}
