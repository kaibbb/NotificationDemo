package com.dtcj.liukai.notificationdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * Author: liuk
 * Created at: 16/3/31
 */
public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //判断app进程是否存活
        if(SystemUtils.isAppAlive(context, "com.dtcj.liukai.notificationdemo")){
            Log.i("NotificationReceiver", "the app process is alive");
            Intent mainIntent = new Intent(context, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            Intent detailIntent = new Intent(context, DetailActivity.class);
            detailIntent.putExtra("name", "哈哈哈哈哈哈哈哈哈哈哈");
            detailIntent.putExtra("price", "喝啥哈哈哈哈哈哈哈哈啊哈哈哈哈哈哈哈哈哈");
            detailIntent.putExtra("detail", "这是app进程存在，直接启动Activity的");

            Intent[] intents = {mainIntent, detailIntent};

            context.startActivities(intents);
        }else {
            Log.i("NotificationReceiver", "the app process is dead");
            Intent launchIntent = context.getPackageManager().
                    getLaunchIntentForPackage("com.dtcj.liukai.notificationdemo");
            launchIntent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            Bundle args = new Bundle();
            args.putString("name", "电饭锅");
            args.putString("price", "58元");
            args.putString("detail", "这是一个好锅, 这是app进程不存在，先启动应用再启动Activity的");
            launchIntent.putExtra(Constants.EXTRA_BUNDLE, args);
            context.startActivity(launchIntent);
        }
    }
}
