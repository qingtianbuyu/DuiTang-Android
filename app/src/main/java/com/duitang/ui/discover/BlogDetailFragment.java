package com.duitang.ui.discover;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.AppConst;
import com.duitang.base.ObjectList;
import com.duitang.entity.Blog;
import com.duitang.entity.BlogDetail;
import com.duitang.http.DiscoverHttp;
import com.duitang.util.RetrofitUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/18 下午5:04
 */
public class BlogDetailFragment extends Fragment {
    Blog blog;
    boolean isloaded;
    @BindView(R.id.recycler)
    RecyclerView recyclerView;

    public static BlogDetailFragment newInstance() {
        Bundle args = new Bundle();
        BlogDetailFragment fragment = new BlogDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_blog, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onResume() {
        super.onResume();
        if (blog != null) {
            Log.e("TAG", blog.getId() + "--recycler--" + recyclerView);
        }
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public void loadData() {
        if (!isloaded && blog != null) {
            loadBlogData();
            isloaded = true;
        }
    }

    public void loadBlogData() {
        DiscoverHttp.loadBlogList(blog.getId(), new RetrofitUtil.RequestCallBack<BlogDetail>() {
            @Override
            public void success(BlogDetail data) {
                //刷新页面
                initAdapter(data);
            }

            @Override
            public void failure(String failure) {

            }
        });
    }

    public void initAdapter(BlogDetail detail) {
        BlogRelatedAlbumAdapter adapter = new BlogRelatedAlbumAdapter(detail);
        recyclerView.setAdapter(adapter);
    }

}
