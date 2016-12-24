package com.duitang.ui.discover.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duitang.R;
import com.duitang.base.AppConst;
import com.duitang.base.BaseListFragment;
import com.duitang.base.ObjectList;
import com.duitang.entity.Blog;
import com.duitang.entity.Trend;
import com.duitang.http.DiscoverHttp;
import com.duitang.ui.discover.BlogDetailActivity;
import com.duitang.ui.discover.FollowTrendActivity;
import com.duitang.ui.discover.FollowTrendAdapter;
import com.duitang.ui.discover.UserInfoActivity;
import com.duitang.ui.home.AlbumDetailActivity;
import com.duitang.ui.home.ArticleDetailActivity;
import com.duitang.util.RetrofitUtil;

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
public class UserTrendFragment extends UserBaseFragment {
    @BindView(R.id.swipe_target)
    RecyclerView recycler;
    private int start;
    private FollowTrendAdapter adapter;
    List<Trend> trendList = new ArrayList<>();

    public static UserTrendFragment newInstance() {
        Bundle args = new Bundle();
        UserTrendFragment fragment = new UserTrendFragment();
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
        loadTrend();
    }

    @Override
    public void initListView(View view) {
        super.initListView(view);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        swipeToLoadLayout.setRefreshEnabled(false);
    }

    public void loadTrend() {
        DiscoverHttp.momentListByUser(trend.getPublisher().getId(), start, new RetrofitUtil.RequestCallBack<ObjectList<Trend>>() {
            @Override
            public void success(ObjectList<Trend> data) {
                if (data != null && data.object_list != null) {
                    trendList.addAll(data.object_list);
                }
                initAdapter();
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    public void initAdapter() {
        processPublisherInfo();
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
//                    Intent intent = new Intent(FollowTrendActivity.this, targetClz);
//                    intent.putExtra("albumId", trend.getId() + "");
//                    startActivity(intent);
                }

                @Override
                public void onItemBlogClick(Trend trend, Blog blog) {
//                    Intent intent = new Intent(FollowTrendActivity.this, BlogDetailActivity.class);
//                    intent.putExtra(AppConst.BlogDetailActivityConst.KEY_TREND, trend);
//                    intent.putExtra(AppConst.BlogDetailActivityConst.KEY_POSITION, trend.getBlogs().indexOf(blog));
//                    startActivity(intent);
                }

                @Override
                public void onItemHeaderClick(int layoutPosition) {
                    Trend trend = trendList.get(layoutPosition);
//                    Intent intent = new Intent(FollowTrendActivity.this, UserInfoActivity.class);
//                    intent.putExtra(AppConst.BlogDetailActivityConst.KEY_TREND, trend);
//                    startActivity(intent);
                }
            });
        } else {
            adapter.notifyDataSetChanged();
        }
    }


    public void processPublisherInfo() {
        for (Trend trend : trendList) {
            trend.setPublisher(this.trend.getPublisher());
        }
    }
}
