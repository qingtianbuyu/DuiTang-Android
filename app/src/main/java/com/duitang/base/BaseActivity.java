package com.duitang.base;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Title: Activity的基础父类
 * description: 用于一些统一的初始化操作
 * author: yking
 * created on: 2016/12/3 下午11:59
 */
public class BaseActivity extends AppCompatActivity {

    public void exitClick(View view) {
        finish();
    }
}
