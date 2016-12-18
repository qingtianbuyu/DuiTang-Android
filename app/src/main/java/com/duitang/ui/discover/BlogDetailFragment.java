package com.duitang.ui.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duitang.base.AppConst;
import com.duitang.entity.Blog;


/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/18 下午5:04
 */
public class BlogDetailFragment extends Fragment {
    Blog blog;
    boolean isloaded;

    public static BlogDetailFragment newInstance(Blog blog) {
        Bundle args = new Bundle();
        BlogDetailFragment fragment = new BlogDetailFragment();
        args.putSerializable(AppConst.BlogDetailActivityConst.KEY_BLOG, blog);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        blog = (Blog) arguments.getSerializable(AppConst.BlogDetailActivityConst.KEY_BLOG);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return new TextView(container.getContext());
    }

    public void loadData() {
        // TODO: 2016/12/18 加载数据
        if (!isloaded) {
            loadBlogData();
            isloaded = true;
        }
    }

    public void loadBlogData() {
        Log.d("TAG", "---" + blog.getId());
    }

}
