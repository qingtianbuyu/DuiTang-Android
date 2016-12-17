package com.duitang.ui.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.BaseActivity;
import com.duitang.base.ObjectList;
import com.duitang.entity.Trend;
import com.duitang.http.DiscoverHttp;
import com.duitang.util.RetrofitUtil;
import com.duitang.view.refresh.ListViewDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Title:关注动态
 * description:
 * author: yking
 * created on: 2016/12/13 下午9:41
 */
public class FollowTrendActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.imgbtn_left)
    ImageButton imgBtnLeft;

    @BindView(R.id.imgbtn_right)
    ImageButton imgBtnRight;

    List<Trend> trendList = new ArrayList<>();
    @BindView(R.id.recycler)
    RecyclerView recycler;
    private FollowTrendAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_trends);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    public void initData() {
        DiscoverHttp.loadBroadcastList(0, new RetrofitUtil.RequestCallBack<ObjectList<Trend>>() {
            @Override
            public void success(ObjectList<Trend> data) {
                if (data != null && data.object_list != null) {
                    trendList.addAll(data.object_list);
                }
                initAdapter();
                restoreRefresh();
            }

            @Override
            public void failure(String failure) {
                restoreRefresh();
            }
        });
    }

    public void initAdapter() {
        if (adapter == null) {
            adapter = new FollowTrendAdapter(trendList);
            recycler.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }


    public void restoreRefresh() {

    }

    public void initView() {
        tvTitle.setText("关注动态");
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new ListViewDecoration(this));
    }

    @OnClick(R.id.imgbtn_right)
    public void rightClick() {
        startActivity(new Intent(this, RecommandDaringActivity.class));
    }


}
