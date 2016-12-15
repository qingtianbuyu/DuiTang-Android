package com.duitang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.blankj.utilcode.utils.BarUtils;
import com.blankj.utilcode.utils.ScreenUtils;

/**
 * Title: Activity的基础父类
 * description: 用于一些统一的初始化操作
 * author: yking
 * created on: 2016/12/3 下午11:59
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ScreenUtils.setPortrait(this);
    }

    public void exitClick(View view) {
        finish();
    }
}
