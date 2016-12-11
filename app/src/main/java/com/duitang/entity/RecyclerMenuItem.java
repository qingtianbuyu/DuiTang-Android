package com.duitang.entity;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/10 下午4:36
 */
public class RecyclerMenuItem {

    public static final int KEY_BLANK_DIVER = 0;
    public static final int KEY_TYPE_NORMAL = 1;

    public int resId;
    public String text;
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
