package com.example.uuid;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    protected static final String FCMTAG = "[FCM Service]";

    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.d(FCMTAG, "onMessageReceived is called");

        String msg, title;
        msg = remoteMessage.getNotification().getBody();
        title = remoteMessage.getNotification().getTitle();

        Notification.Builder noti = new Notification.Builder(this)
                .setContentTitle("New push from : " + title)
                .setContentText(msg)
                .setSmallIcon(R.mipmap.ic_launcher);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, noti.build());


    }

}