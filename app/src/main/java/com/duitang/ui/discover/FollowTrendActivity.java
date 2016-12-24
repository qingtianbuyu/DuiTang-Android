package com.duitang.ui.discover;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.AppConst;
import com.duitang.base.BaseActivity;
import com.duitang.base.ObjectList;
import com.duitang.entity.Blog;
import com.duitang.entity.Trend;
import com.duitang.http.DiscoverHttp;
import com.duitang.ui.home.AlbumDetailActivity;
import com.duitang.ui.home.ArticleDetailActivity;
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
            adapter.setOnTrendItemClickListener(new FollowTrendAdapter.OnTrendItemClickListener() {
                @Override
                public void onItemClick(int layoutPosition) {
                    int itemViewType = adapter.getItemViewType(layoutPosition);
                    Class targetClz = null;
                    if (itemViewType == FollowTrendAdapter.KEY_ARTICLE) {
                        targetClz = ArticleDetailActivity.class;
                    } else if (itemViewType == FollowTrendAdapter.KEY_ALBUM) {
                        targetClz = AlbumDetailActivity.class;
                    }
                    Trend trend = trendList.get(layoutPosition);
                    Intent intent = new Intent(FollowTrendActivity.this, targetClz);
                    intent.putExtra("albumId", trend.getId() + "");
                    startActivity(intent);
                }

                @Override
                public void onItemBlogClick(Trend trend, Blog blog) {
                    Intent intent = new Intent(FollowTrendActivity.this, BlogDetailActivity.class);
                    intent.putExtra(AppConst.BlogDetailActivityConst.KEY_TREND, trend);
                    intent.putExtra(AppConst.BlogDetailActivityConst.KEY_POSITION, trend.getBlogs().indexOf(blog));
                    startActivity(intent);
                }

                @Override
                public void onItemHeaderClick(int layoutPosition) {
                    Trend trend = trendList.get(layoutPosition);
                    Intent intent = new Intent(FollowTrendActivity.this, UserInfoActivity.class);
                    intent.putExtra(AppConst.BlogDetailActivityConst.KEY_TREND, trend);
                    startActivity(intent);
                }
            });
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
