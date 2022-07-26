package com.example.fragment_app;

import static com.example.fragment_app.NotificationApp.CHANNEL_ID;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class NotificationService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String input =intent.getStringExtra("EXTRA_INPUT");

        Intent notificationIntent=new Intent(this,MainActivity2.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,notificationIntent,0);

        Notification notification=new NotificationCompat.Builder(this,CHANNEL_ID).setContentTitle("IntentService").setContentText(input).setSmallIcon(R.drawable.ic_android).setContentIntent(pendingIntent).build();
        startForeground(1,notification);
//        Below method helps when heavy work runs in the background thread
//       stopSelf();
        return START_NOT_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
