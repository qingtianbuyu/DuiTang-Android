package com.duitang.util;

import android.content.Context;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午2:14
 */
public class ResourcesUtil {
    /**
     * 获取对应资源字符串
     */
    public static String getString(Context context, int stringResId)
    {
        return context.getResources().getString(stringResId);
    }
}
