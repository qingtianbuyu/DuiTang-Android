package com.duitang.ui.discover;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.duitang.R;
import com.duitang.base.BaseActivity;
import com.duitang.entity.RecyclerMenuItem;
import com.duitang.entity.User;
import com.duitang.http.DiscoverHttp;
import com.duitang.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:推荐你关注的达人
 * description:
 * author: yking
 * created on: 2016/12/13 下午10:00
 */
public class RecommandDaringActivity extends BaseActivity {

    @BindView(R.id.recycler)
    RecyclerView recyclerView;
    List<User> userList = new ArrayList<>();
    RecommandDaringAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommand_daring);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    public void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


    public void initData() {
        DiscoverHttp.loadRecommnadDaringList(new RetrofitUtil.RequestCallBack<List<User>>() {
            @Override
            public void success(List<User> data) {
                userList.clear();
                if (data != null) {
                    userList.addAll(data);
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
            adapter = new RecommandDaringAdapter(userList);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
