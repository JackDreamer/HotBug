package com.ts.hotbug;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<BugClass> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BugClass bugClass = new BugClass(MainActivity.this);
        mList = new ArrayList<>();
        testLeakMemory();

    }

    private void testLeakMemory() {
        while (true) {
            BugClass bugClass1 = new BugClass(MainActivity.this);
            mList.add(bugClass1);
            bugClass1 = null;
        }
    }
}
