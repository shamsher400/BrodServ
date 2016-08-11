package com.shamsher.brodserv;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by shamsher on 22/6/16.
 */
public class ServiceS extends Service {
    CountDownTimer aCounter;
    Context context=this;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        aCounter = new CountDownTimer(60000 , 1000) {
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                Toast.makeText(context, "Application Running", Toast.LENGTH_LONG).show();
                aCounter.start();
            }
        };aCounter.start();
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        Toast.makeText(context, "Service Destroy", Toast.LENGTH_LONG).show();
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
}
