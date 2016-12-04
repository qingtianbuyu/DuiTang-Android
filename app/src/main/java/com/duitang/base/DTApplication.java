package com.duitang.base;

import android.app.Application;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午2:00
 */
public class DTApplication extends Application{

    private static DTApplication ourInstance;
    public static DTApplication getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
    }
}
