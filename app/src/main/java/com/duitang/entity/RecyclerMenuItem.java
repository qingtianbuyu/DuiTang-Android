package com.duitang.entity;

import android.app.Activity;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/10 下午4:36
 */
public class RecyclerMenuItem {

    public static final int KEY_BLANK_DIVER = 0;
    public static final int KEY_TYPE_NORMAL = 1;
    public static final int KEY_TYPE_ORDER = 2;
    public static final int KEY_TYPE_ICON = 3;

    public int resId;
    public String text;
    public Class<? extends Activity> action;

    public boolean showArrow;
    public int type;

    public RecyclerMenuItem(int resId, String text, int type) {
        this.resId = resId;
        this.text = text;
        this.type = type;
    }

    public RecyclerMenuItem() {

    }
}
