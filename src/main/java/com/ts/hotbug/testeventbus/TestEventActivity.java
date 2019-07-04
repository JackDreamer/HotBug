package com.ts.hotbug.testeventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.ts.hotbug.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TestEventActivity extends Activity {

    private TextView tvTest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);
        tvTest = findViewById(R.id.tv_test);
        tvTest.setText("今天吃什么呢");
        jumpToEventActivity();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void Event(EventDao dao) {
        tvTest.setText(dao.getmMessage());

    }

    private void jumpToEventActivity(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
            }
        }).start();
        startActivity(new Intent(TestEventActivity.this,EventActivity.class));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);

        }
    }
}
