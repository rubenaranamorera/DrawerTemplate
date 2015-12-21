package com.armoz.drawertemplate.base.view.errors;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.armoz.drawertemplate.R;
import com.armoz.drawertemplate.base.domain.events.ErrorEvent;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import hugo.weaving.DebugLog;

/**
 * Component used for displaying UserNotifications
 * <p/>
 * Should a Listener be provided, notification will stay on device screen until user taps on it (and goes to the listener functions), or dismisses it pressing the Close button
 * If no listener is provided, notification won't have any interaction, and will stay visible just for a little time
 * USAGE - HOW TO NOTIFY AN ErrorEvent
 *
 * @Override public boolean showError(ErrorEvent event) {
 * progressBar.progressiveStopDelayed();
 * UserNotificator.show(getActivity(),
 * UserNotificator.buildNotificationForError(getActivity(),event));
 * }
 * <p/>
 * USAGE - HOW TO SHOW A CUSTOM NOTIFICATION
 * UserNotification notification = new UserNotification();
 * notification.setType(UserNotification.Type.ERROR);
 * notification.setMessage("TIENES 8 VISUALIZACIONES");
 * notification.setListener(new UserNotificationCallbackListener() {
 * @Override public void onUserNotificationAction(Object callbackInfo) {
 * testNotificationCallback(callbackInfo);
 * }
 * });
 * UserNotificator.show(getActivity(), notification);
 */
public class UserNotificator {

    public static final int CROUTON_DURATION_WHEN_AUTO_HIDDEN = 5000;

    @DebugLog
    public static void show(@NonNull Activity activity, @NonNull final UserNotification userNotification) {
        show(activity, userNotification, null);
    }

    @DebugLog
    public static void show(@NonNull Activity activity, @NonNull final UserNotification userNotification, ViewGroup container) {
        if (activity == null || userNotification == null) {
            return;
        }

        final Crouton activeCrouton;

        int backgoundColor = activity.getResources().getColor(R.color.notification_background_info);
        int textColor = activity.getResources().getColor(R.color.notification_text_info);

        switch (userNotification.getType()) {
            case ERROR:
                backgoundColor = activity.getResources().getColor(R.color.notification_background_error);
                textColor = activity.getResources().getColor(R.color.notification_text_error);
                break;
            case WARN:
                backgoundColor = activity.getResources().getColor(R.color.notification_background_warning);
                textColor = activity.getResources().getColor(R.color.notification_text_warning);
                break;
            case GOODNEWS:
                backgoundColor = activity.getResources().getColor(R.color.notification_background_goodnews);
                textColor = activity.getResources().getColor(R.color.notification_text_goodnews);
                break;
        }
        View croutonView = LayoutInflater.from(activity).inflate(R.layout.item_notification, null, false);
        croutonView.setBackgroundColor(backgoundColor);
        TextView messageText = (TextView) croutonView.findViewById(R.id.notification_message);
        messageText.setTextColor(textColor);

        // Conditional formatting
        boolean hasAction = (userNotification.getListener() != null);

        // Fill UI
        messageText.setText(userNotification.getMessage());

        Configuration.Builder configurationBuilder = new Configuration.Builder();

        // Show the message
        if (container == null) {
            container = (ViewGroup) activity.findViewById(R.id.frame_layout); //Getting the container where we want to put the Crouton
        }

        if (container != null) {
            activeCrouton = Crouton.make(activity, croutonView, container);
        } else {
            activeCrouton = Crouton.make(activity, croutonView);
        }

        // Do we have an action?
        if (!hasAction) {
            configurationBuilder.setDuration(userNotification.getDuration());
            croutonView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Crouton.hide(activeCrouton);
                }
            });
        }

        // Set config and show
        activeCrouton.setConfiguration(configurationBuilder.build()).show();
    }

    public static UserNotification buildNotificationForError(@NonNull Context applicationContext, ErrorEvent event) {
        if (applicationContext == null) {
            return null;
        }

        UserNotification userNotification = new UserNotification();
        // Corner case: Unknown, uninformed error... just rant
        userNotification.setMessage(event.getMessage());

        return userNotification;
    }
}
