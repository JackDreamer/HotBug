package com.ts.hotbug.testeventbus;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;

import com.ts.hotbug.R;

import org.greenrobot.eventbus.EventBus;

public class EventActivity extends Activity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jumpToTestActivity();
    }

    private void jumpToTestActivity() {

        EventBus.getDefault().post(new EventDao("想吃啥就吃啥"));
        new Thread(new Runnable() {
            @Override
            public void run() {
             SystemClock.sleep(2000);
             finish();
            }
        }).start();

    }
}
