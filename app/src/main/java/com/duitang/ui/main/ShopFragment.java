package com.duitang.ui.main;

import android.os.Bundle;

import com.duitang.base.BaseFragment;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 上午10:04
 */
public class ShopFragment extends BaseFragment {
    public static ShopFragment newInstance() {
        Bundle args = new Bundle();
        ShopFragment fragment = new ShopFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
