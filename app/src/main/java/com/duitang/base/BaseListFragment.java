package com.duitang.base;

import android.util.Log;
import android.view.View;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.duitang.R;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午12:28
 */
public class BaseListFragment extends BaseFragment implements OnRefreshListener, OnLoadMoreListener {

    public SwipeToLoadLayout swipeToLoadLayout;

    /**
     * 初始化ListView
     */
    public void initListView(View view) {
        swipeToLoadLayout = (SwipeToLoadLayout) view.findViewById(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
    }

    /**
     * 退出刷新状态
     */
    public void restoreRefreshState() {
        if (swipeToLoadLayout == null) {
            Log.e("INITAL_ERROR", "swipeToLoadLayout initial failed");
            return;
        }

        if (swipeToLoadLayout.isRefreshing()) {
            swipeToLoadLayout.setRefreshing(false);
        } else if (swipeToLoadLayout.isLoadingMore()) {
            swipeToLoadLayout.setLoadingMore(false);
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
