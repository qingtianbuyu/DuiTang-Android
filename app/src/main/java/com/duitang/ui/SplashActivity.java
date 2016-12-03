package com.duitang.ui;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.duitang.R;
import com.duitang.base.BaseActivity;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/3 下午11:59
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }
        }, 2 * 1000l);
    }

    @Override
    public void onBackPressed() {

    }
}
