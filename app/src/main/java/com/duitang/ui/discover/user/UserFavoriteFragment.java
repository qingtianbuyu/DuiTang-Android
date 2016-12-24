package com.duitang.ui.discover.user;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.BaseListFragment;
import com.duitang.base.ObjectList;
import com.duitang.entity.Favorite;
import com.duitang.entity.Trend;
import com.duitang.http.HomeHttp;
import com.duitang.util.RetrofitUtil;
import com.duitang.view.refresh.ListViewDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/24 下午2:34
 */
public class UserFavoriteFragment extends UserBaseFragment {
    @BindView(R.id.swipe_target)
    RecyclerView recycler;
    private int start;
    List<Favorite> favoriteList = new ArrayList<>();
    UserFavoriteAdapter adapter;

    public static UserFavoriteFragment newInstance() {
        Bundle args = new Bundle();
        UserFavoriteFragment fragment = new UserFavoriteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_user_trend, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initListView(view);
        loadFavoriteData();
    }

    public void loadFavoriteData() {
        HomeHttp.favoriteList(trend.getPublisher().getId(), start, new RetrofitUtil.RequestCallBack<ObjectList<Favorite>>() {
            @Override
            public void success(ObjectList<Favorite> data) {
                if (data != null) {
                    favoriteList.addAll(data.object_list);
                }
                initAdapter();
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    public void initAdapter() {
        if (adapter == null) {
            adapter = new UserFavoriteAdapter(favoriteList);
            recycler.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }


    @Override
    public void initListView(View view) {
        super.initListView(view);
        recycler.addItemDecoration(new ListViewDecoration(getContext()));
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        swipeToLoadLayout.setRefreshEnabled(false);
    }
}
