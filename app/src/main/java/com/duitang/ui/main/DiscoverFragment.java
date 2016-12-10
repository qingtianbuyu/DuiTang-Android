package com.duitang.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duitang.R;
import com.duitang.base.BaseFragment;
import com.duitang.base.ObjectList;
import com.duitang.entity.ContentGroup;
import com.duitang.http.DiscoverHttp;
import com.duitang.util.RetrofitUtil;

import java.security.acl.Group;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title: 发现
 * description:
 * author: yking
 * created on: 2016/12/4 上午10:04
 */
public class DiscoverFragment extends BaseFragment {
    @BindView(R.id.recycler)
    RecyclerView recycler;

    DiscoverAdapter adapter;
    List<ContentGroup> dataList = new ArrayList<>();

    public static DiscoverFragment newInstance() {
        Bundle args = new Bundle();
        DiscoverFragment fragment = new DiscoverFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_discover, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupRecyclerView();
        initData();
    }

    public void setupRecyclerView() {
        recycler.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recycler.setItemAnimator(new DefaultItemAnimator());
    }


    /**
     * 初始化数据
     */
    public void initData() {
        DiscoverHttp.loadContentList(new RetrofitUtil.RequestCallBack<List<ContentGroup>>() {
            @Override
            public void success(List<ContentGroup> data) {
                if (data != null) {
                    dataList.addAll(data);
                    initAdapter();
                }
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    /**
     * 刷新列表
     */
    public void initAdapter() {
        if (adapter == null) {
            adapter = new DiscoverAdapter(dataList);
            recycler.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }


}
