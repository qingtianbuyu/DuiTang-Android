package com.duitang.ui.discover.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duitang.base.BaseListFragment;
import com.duitang.entity.Trend;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/24 下午2:34
 */
public class UserArticleFragment extends UserBaseFragment {

    public static UserArticleFragment newInstance() {
        Bundle args = new Bundle();
        UserArticleFragment fragment = new UserArticleFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new TextView(container.getContext());
    }
}
