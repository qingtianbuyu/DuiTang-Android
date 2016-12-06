package com.duitang.ui.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.blankj.utilcode.utils.SizeUtils;
import com.duitang.R;
import com.duitang.base.BaseActivity;
import com.duitang.base.ObjectList;
import com.duitang.entity.Album;
import com.duitang.entity.AlbumData;
import com.duitang.entity.Topic;
import com.duitang.http.HomeHttp;
import com.duitang.util.RetrofitUtil;
import com.duitang.view.refresh.SpaceItemDecoration;

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
public class AlbumDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgbtn_right)
    ImageButton imgbtnRight;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    AlbumDetailAdapter adapter;
    Topic topic;
    Album album;
    List<AlbumData> albumDatas = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    public void initView() {
        imgbtnRight.setImageResource(R.mipmap.nav_more);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    public void initData() {
        topic = (Topic) getIntent().getSerializableExtra("topic");
        HomeHttp.listAlbumDetail(topic.getTargetId(), new RetrofitUtil.RequestCallBack<Album>() {
            @Override
            public void success(Album data) {
                album = data;
//                initAdapter();
                listAlbumList(data.getUser().getId());
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    public void listAlbumList(int userId) {
        HomeHttp.listAlbumList(topic.getTargetId(), userId, new RetrofitUtil.RequestCallBack<ObjectList<AlbumData>>() {

            @Override
            public void success(ObjectList data) {
                // 刷新recyclerView
                albumDatas.clear();
                if (data.object_list != null) {
                    albumDatas.addAll(data.object_list);
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
            adapter = new AlbumDetailAdapter(albumDatas);
            adapter.setAlbum(album);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setAlbum(album);
            adapter.notifyDataSetChanged();
        }
    }
}
