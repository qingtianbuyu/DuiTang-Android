package com.duitang.ui.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duitang.R;
import com.duitang.base.BaseListFragment;
import com.duitang.base.ObjectList;
import com.duitang.entity.ColumnData;
import com.duitang.entity.TopicData;
import com.duitang.http.DiscoverHttp;
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
 * created on: 2016/12/25 下午12:49
 */
public class ClubFragment extends BaseListFragment {

    int start;
    ClubAdapter clubAdapter;
    List<ColumnData> columnDataList = new ArrayList<>();
    List<TopicData> topicDataList = new ArrayList<>();
    @BindView(R.id.swipe_target)
    RecyclerView recyclerView;

    public static ClubFragment newInstance() {
        Bundle args = new Bundle();
        ClubFragment fragment = new ClubFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_club, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        setupRecyclerView();
    }

    public void setupRecyclerView() {
        recyclerView.addItemDecoration(new ListViewDecoration(getContext()));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onStart() {
        super.onStart();
        topicListByTags();
        columnDetailByHeapName();
    }

    private void columnDetailByHeapName() {
        DiscoverHttp.columnDetailByHeapName(0, new RetrofitUtil.RequestCallBack<ObjectList<ColumnData>>() {
            @Override
            public void success(ObjectList<ColumnData> data) {
                if (data != null) {
                    columnDataList.addAll(data.object_list);
                }
                initAdapter();
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    public void topicListByTags() {
        DiscoverHttp.topicListByTags(start, "精选", new RetrofitUtil.RequestCallBack<ObjectList<TopicData>>() {
            @Override
            public void success(ObjectList<TopicData> data) {
                if (data != null) {
                    topicDataList.addAll(data.object_list);
                }
                initAdapter();
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    public void initAdapter() {
        if (clubAdapter == null) {
            clubAdapter = new ClubAdapter();
            clubAdapter.setColumnDataList(columnDataList);
            clubAdapter.setTopicDataList(topicDataList);
            recyclerView.setAdapter(clubAdapter);
        } else {
            clubAdapter.notifyDataSetChanged();
        }
    }
}
