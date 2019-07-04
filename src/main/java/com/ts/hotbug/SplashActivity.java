package com.ts.hotbug;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.dfqin.grantor.PermissionListener;
import com.github.dfqin.grantor.PermissionsUtil;
import com.ts.hotbug.customview.DateTimeActivity;
import com.ts.hotbug.service.ScreenGuardService;

import java.io.File;

public class SplashActivity extends AppCompatActivity implements PermissionListener {
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTest = findViewById(R.id.tv_test);
        init();
    }


    private void init() {

        String[] permissions = {Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};

        PermissionsUtil.requestPermission(SplashActivity.this, this,
                permissions);

        File externalStorageDirectory = Environment.getExternalStorageDirectory();

        // 遍历所有的修复dex , 因为可能是多个dex修复包
        File fileDir = externalStorageDirectory != null ?
                externalStorageDirectory :
                new File(getFilesDir(), FixDexUtil.DEX_DIR);// data/user/0/包名/files/odex（这个可以任意位置）
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        if (FixDexUtil.isGoingToFix(this)) {

            FixDexUtil.loadFixedDex(this, Environment.getExternalStorageDirectory());
            tvTest.setText("正在修复。。。。");

        }
        //开启服务
        startService(new Intent(SplashActivity.this, ScreenGuardService.class));

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                startActivity(new Intent(SplashActivity.this, DateTimeActivity.class));
//                finish();
//            }
//        }, 3000);
    }

    @Override
    public void permissionGranted(@NonNull String[] permission) {

    }

    @Override
    public void permissionDenied(@NonNull String[] permission) {

    }
}
