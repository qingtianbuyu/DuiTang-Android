package com.duitang.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午8:06
 */
public class ImageLoaderHelper {
    private volatile static ImageLoaderHelper ourInstance;

    public static ImageLoaderHelper getInstance() {
        if (ourInstance == null) {
            synchronized (ImageLoaderHelper.class) {
                if (ourInstance == null) {
                    ourInstance = new ImageLoaderHelper();
                }
            }
        }
        return ourInstance;
    }


    private ImageLoaderHelper() {

    }

    public static void loadImageView(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).into(mImageView);
    }

    public interface SimpleLoadImageListener {

        void onLoadingStarted(String imageUri, View view);

        void onLoadingFailed(String imageUri, View view);

        void onLoadingComplete(String imageUri, View view, Bitmap loadedImage);
    }
}
