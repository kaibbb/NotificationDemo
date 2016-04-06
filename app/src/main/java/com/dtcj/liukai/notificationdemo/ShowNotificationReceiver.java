package com.dtcj.liukai.notificationdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Author: liuk
 * Created at: 16/3/31
 */
public class ShowNotificationReceiver extends BroadcastReceiver {

    private static final String TAG = "RepeatReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "ShowNotificationReceiver onReceive");
        Intent broadcastIntent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.
                getBroadcast(context, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("notif head")
                .setTicker("notif ticker")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_dt);

        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, builder.build());
    }
}
