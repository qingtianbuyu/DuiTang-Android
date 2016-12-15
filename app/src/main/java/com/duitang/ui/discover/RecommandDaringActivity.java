package com.duitang.ui.discover;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.duitang.R;
import com.duitang.base.BaseActivity;
import com.duitang.base.ObjectList;
import com.duitang.entity.User;
import com.duitang.entity.callback.UserCallback;
import com.duitang.http.DiscoverHttp;
import com.duitang.util.RetrofitUtil;
import com.duitang.view.refresh.ListViewDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.btn_right)
    Button btnRight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommand_daring);
        ButterKnife.bind(this);
        initView();
        initData();
        setListener();
    }

    public void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new ListViewDecoration(this));
    }


    public void initData() {
        tvTitle.setText("推荐你关注的达人");
        btnRight.setText("完成");
        btnRight.setTextColor(Color.RED);
        DiscoverHttp.loadRecommnadDaringList(new RetrofitUtil.RequestCallBack<ObjectList<User>>() {
            @Override
            public void success(ObjectList<User> data) {
                userList.clear();
                if (data != null) {
                    userList.addAll(data.object_list);
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
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new UserCallback(userList, userList));
            diffResult.dispatchUpdatesTo(adapter);
        }
    }

    public void setListener() {
        recyclerView.addOnItemTouchListener(new OnItemClickListener() {

            @Override
            public void onSimpleItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {

            }

            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                super.onItemChildClick(adapter, view, position);

            }
        });
    }


    @OnClick(R.id.btn_right)
    public void rightClick() {
        finish();
    }
}
