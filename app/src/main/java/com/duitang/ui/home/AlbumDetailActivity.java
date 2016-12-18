package com.duitang.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.duitang.R;
import com.duitang.base.BaseActivity;
import com.duitang.base.ObjectList;
import com.duitang.entity.Album;
import com.duitang.entity.AlbumData;
import com.duitang.entity.Topic;
import com.duitang.http.HomeHttp;
import com.duitang.util.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:专辑详情
 * description:
 * author: yking
 * created on: 2016/12/4 下午11:05
 */
public class AlbumDetailActivity extends BaseActivity implements OnRefreshListener, OnLoadMoreListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgbtn_right)
    ImageButton imgbtnRight;
    @BindView(R.id.swipe_target)
    RecyclerView recyclerView;
    @BindView(R.id.swipeToLoadLayout)
    SwipeToLoadLayout swipeToLoadLayout;

    AlbumDetailAdapter adapter;
    List<AlbumData> albumDatas = new ArrayList<>();

    String albumId;
    Album album;
    int userId;
    int start;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    public void initView() {
        swipeToLoadLayout.setOnLoadMoreListener(this);
        swipeToLoadLayout.setOnRefreshListener(this);
        imgbtnRight.setImageResource(R.mipmap.nav_more);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void initData() {
        albumId =  getIntent().getStringExtra("albumId");
        HomeHttp.listAlbumDetail(albumId, new RetrofitUtil.RequestCallBack<Album>() {
            @Override
            public void success(Album data) {
                album = data;
                userId = data.getUser().getId();
                listAlbumList();
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    public void listAlbumList() {
        HomeHttp.listAlbumList(albumId, userId, start, new RetrofitUtil.RequestCallBack<ObjectList<AlbumData>>() {

            @Override
            public void success(ObjectList data) {
                start = data.next_start;
                // 刷新recyclerView
                if (swipeToLoadLayout.isRefreshing()) {
                    albumDatas.clear();
                }
                if (data.object_list != null) {
                    albumDatas.addAll(data.object_list);
                }
                boolean loadMoreEnabled = data.more == 1;
                if (loadMoreEnabled) {
                    swipeToLoadLayout.setLoadMoreEnabled(loadMoreEnabled);
                }

                initAdapter();
                restoreRefreshState();
            }

            @Override
            public void failure(String failure) {
                if (swipeToLoadLayout.isRefreshing()) {
                    albumDatas.clear();
                    start = 1;
                }
                initAdapter();
                restoreRefreshState();
            }
        });
    }


    public void initAdapter() {
        if (adapter == null) {
            adapter = new AlbumDetailAdapter(albumDatas);
            adapter.setAlbum(album);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setAlbum(album);
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onRefresh() {
        listAlbumList();
    }

    @Override
    public void onLoadMore() {
        listAlbumList();
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
        }
        if (swipeToLoadLayout.isLoadingMore()) {
            swipeToLoadLayout.setLoadingMore(false);
        }
    }
}
