package com.ts.hotbug;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * bug测试类
 */
public class BugClass {

    public BugClass() {
    }

    public BugClass(Context context){
        Toast.makeText(context,"这是一个优美的bug,已成功修复！！",Toast.LENGTH_SHORT).show();
    }


}