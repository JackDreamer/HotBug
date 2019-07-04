package com.ts.hotbug.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ts.hotbug.customview.DateTimeActivity;
import com.ts.hotbug.listener.ScreenListener;

public class ScreenGuardService extends Service implements ScreenListener.ScreenStateListener {


    private ScreenListener screenListener;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("vivi", "onCreate: ");
        screenListener = new ScreenListener(ScreenGuardService.this);
        screenListener.begin(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("vivi", "onStartCommand: ");
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onScreenOn() {
        Log.d("vivi", "onScreenOn: ");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(ScreenGuardService.this, DateTimeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }, 100);
    }

    //锁屏的时候调用DateTimeActivity
    @Override
    public void onScreenOff() {

        Log.d("vivi", "onScreenOff: ");
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(ScreenGuardService.this, DateTimeActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        }, 500);
    }

    @Override
    public void onUserPresent() {
        Log.d("vivi", "onUserPresent: ");
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(ScreenGuardService.this, DateTimeActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//            }
//        }, 500);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        screenListener.unregisterListener();
    }
}
