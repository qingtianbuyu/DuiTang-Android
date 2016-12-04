package com.duitang.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duitang.base.BaseFragment;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 上午10:04
 */
public class DiscoverFragment extends BaseFragment {
    public static DiscoverFragment newInstance() {
        Bundle args = new Bundle();
        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
