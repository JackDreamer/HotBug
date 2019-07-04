//package com.ts.hotbug.broadcastreceiver;
//
//
//import android.app.KeyguardManager;
//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//
//public class ScreenReceiver extends BroadcastReceiver {
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        //拿到屏幕锁，亮屏，随即释放，否则屏幕就会保持常量
////        WakeUtil.getInstance().wakeScreenLock();
////        WakeUtil.getInstance().releaseScreenLock();
////        //屏蔽系统的屏保
////        mKeyguardManager = (KeyguardManager) MyApplication.getInstance().getSystemService(Context.KEYGUARD_SERVICE);
////        mKeyguardLock = mKeyguardManager.newKeyguardLock("ScreenLockService");
////        mKeyguardLock.disableKeyguard();
//        //TODO 开启自定义的屏保；例如：跳转一个Activity，显示屏保图片
//
//    }
//
//}
