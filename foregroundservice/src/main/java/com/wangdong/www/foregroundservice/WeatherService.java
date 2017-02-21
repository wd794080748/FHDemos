package com.wangdong.www.foregroundservice;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

/**
 * Created by WD on 2017/2/20.
 */

public class WeatherService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        ShowNotification();
    }

    private void ShowNotification() {
        NotificationCompat.Builder mBuilder= (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("tianqi")
                .setContentText("hahaha");
        Intent intent=new Intent(this,Main2Activity.class);
        TaskStackBuilder stackBuilder= TaskStackBuilder.create(this);
        stackBuilder.addParentStack(Main2Activity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(pendingIntent);
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        final Notification notification=mBuilder.build();
        notificationManager.notify(0,notification);
        startForeground(0,notification);


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
