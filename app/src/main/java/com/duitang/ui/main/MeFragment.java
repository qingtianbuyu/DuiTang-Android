package com.duitang.ui.main;

import android.os.Bundle;

import com.duitang.base.BaseFragment;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 上午10:04
 */
public class MeFragment extends BaseFragment {
    public static MeFragment newInstance() {
        Bundle args = new Bundle();
        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
