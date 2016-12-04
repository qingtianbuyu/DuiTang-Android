package com.duitang.util;

import android.view.Gravity;
import android.widget.Toast;

import com.duitang.R;
import com.duitang.base.DTApplication;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午2:10
 */
public class ToastUtils {
    static Toast mToast;


    public static void showButtomToast(String msg) {
        if (mToast == null) {
            initToast();
        }
        mToast.setText(msg);
        mToast.setGravity(Gravity.BOTTOM, 0, DTApplication.getInstance().getResources().getDimensionPixelOffset(R.dimen.toast_y));
        mToast.show();
    }

    public static void showButtomToast(int messageId) {
        if (mToast == null) {
            initToast();
        }
        mToast.setText(messageId);
        mToast.setGravity(Gravity.BOTTOM, 0, DTApplication.getInstance().getResources().getDimensionPixelOffset(R.dimen.toast_y));
        mToast.show();
    }

    public static void showMiddleToast(int id) {
        if (mToast == null) {
            initToast();
        }
        mToast.setText(id);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }

    public static void showMiddleToast(String msg) {
        if (mToast == null) {
            initToast();
        }
        mToast.setText(msg);
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }


    private static void initToast() {
        mToast = new Toast(DTApplication.getInstance());
        mToast = Toast.makeText(DTApplication.getInstance(), "", Toast.LENGTH_SHORT);
    }
}