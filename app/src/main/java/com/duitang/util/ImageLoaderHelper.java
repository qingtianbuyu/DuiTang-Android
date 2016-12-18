package com.duitang.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.duitang.R;

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

    public static void loadImageView(String path, ImageView mImageView) {
        Glide.with(mImageView.getContext())
                .load(path)
                .placeholder(R.mipmap.placeholder)
                .into(mImageView);
    }

    public static void loadImageViewWithCircle(String path, ImageView mImageView) {
        Context mContext = mImageView.getContext();
        Glide.with(mContext)
                .load(path)
                .transform(new GlideCircleTransform(mContext))
                .into(mImageView);
    }

    public static void loadImageViewWithCircle(int path, ImageView mImageView) {
        Context mContext = mImageView.getContext();
        Glide.with(mContext)
                .load(path)
                .transform(new GlideCircleTransform(mContext))
                .into(mImageView);
    }

    public interface SimpleLoadImageListener {

        void onLoadingStarted(String imageUri, View view);

        void onLoadingFailed(String imageUri, View view);

        void onLoadingComplete(String imageUri, View view, Bitmap loadedImage);
    }
}
