package com.haykabelyan.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

public class MyService extends Service {

    NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                sendDeletableNotification();
            }
        }, 5000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                sendDeletableNotification();
            }
        }, 10000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                sendDeletableNotification();
            }
        }, 15000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                sendDeletableNotification();
            }
        }, 20000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                sendDeletableNotification();
            }
        }, 25000);

        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                sendUndeletableNotification();
                startService(new Intent(getApplicationContext(), MyService.class));
            }
        }, 30000);
        return START_STICKY;
    }

    private void sendDeletableNotification() {
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(getApplicationContext());
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = nBuilder.setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.icon).setWhen(System.currentTimeMillis()).setVibrate(new long[]{500, 500})
                .setContentTitle("Notification")
                .setContentText("Deletable notification").build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(1, notification);
    }

    private void sendUndeletableNotification() {
        NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(getApplicationContext());
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        Notification notification = nBuilder.setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.icon).setWhen(System.currentTimeMillis()).setVibrate(new long[]{500, 500})
                .setContentTitle("Notification")
                .setContentText("Undeletable notification").build();
        notification.flags |= Notification.FLAG_NO_CLEAR;
        notificationManager.notify(1, notification);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}