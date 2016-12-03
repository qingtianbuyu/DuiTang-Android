package com.duitang.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.BaseFragment;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 上午1:25
 */
public class HomeFragment extends BaseFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        TextView textView = new TextView(getContext());
        textView.setText("ceshis");
        return textView;
    }
}
