package com.duitang.ui.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.duitang.R;
import com.duitang.base.BaseListFragment;
import com.duitang.base.ObjectList;
import com.duitang.entity.Topic;
import com.duitang.http.HomeHttp;
import com.duitang.ui.home.AlbumDetailActivity;
import com.duitang.ui.home.ArticleDetailActivity;
import com.duitang.util.RetrofitUtil;
import com.duitang.view.refresh.OnRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 上午1:25
 */
public class HomeFragment extends BaseListFragment {

    @BindView(R.id.imgbtn_left)
    ImageButton imgbtnLeft;
    @BindView(R.id.imgbtn_right)
    ImageButton imgbtnRight;
    private RecyclerView recyclerView;
    private int start;
    private List<Topic> topicList = new ArrayList<>();
    TopicAdapter adapter;

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        initView(view);
        imgbtnLeft.setVisibility(View.GONE);
        swipeToLoadLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeToLoadLayout.setRefreshing(true);
            }
        });
    }

    public void initView(View view) {
        initListView(view);
        recyclerView = (RecyclerView) view.findViewById(R.id.swipe_target);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnItemTouchListener(new OnRecyclerItemClickListener(recyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                super.onItemClick(vh);
                int layoutPosition = vh.getLayoutPosition();
                Topic topic = topicList.get(layoutPosition);
                if (topic.getContent_type().equals("pgc")) {
                    Intent intent = new Intent(getContext(), ArticleDetailActivity.class);
                    intent.putExtra("topic", topic);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getContext(), AlbumDetailActivity.class);
                    intent.putExtra("topic", topic);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public void onRefresh() {
        super.onRefresh();
        loadTopic(start);
    }


    @Override
    public void onLoadMore() {
        super.onLoadMore();
        loadTopic(start);
    }

    public void loadTopic(final int page) {
        HomeHttp.loadBannerList(page, new RetrofitUtil.RequestCallBack<ObjectList<Topic>>() {
            @Override
            public void success(ObjectList<Topic> data) {
                List<Topic> objectList = data.object_list;
                if (swipeToLoadLayout.isRefreshing()) {
                    start = 0;
                    topicList.clear();
                }
                start++;
                if (objectList != null && !objectList.isEmpty()) {
                    topicList.addAll(objectList);
                }

                initAdapter();
                restoreRefreshState();
            }

            @Override
            public void failure(String failure) {
                if (swipeToLoadLayout.isRefreshing()) {
                    start = 0;
                    topicList.clear();
                }
                initAdapter();
                restoreRefreshState();
            }
        });
    }

    /**
     * 刷新列表
     */
    public void initAdapter() {
        if (adapter == null) {
            adapter = new TopicAdapter(topicList);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.notifyDataSetChanged();
        }
    }
}
