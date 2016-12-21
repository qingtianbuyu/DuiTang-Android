package com.duitang.ui.discover;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.AppConst;
import com.duitang.base.BaseActivity;
import com.duitang.entity.Blog;
import com.duitang.entity.Trend;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/18 下午4:32
 */
public class BlogDetailActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.imgbtn_left)
    ImageButton imgbtnLeft;
    @BindView(R.id.imgbtn_right)
    ImageButton imgbtnRight;
    @BindView(R.id.vp)
    ViewPager vpFragment;

    List<Blog> blogs;
    int position;
    public List<BlogDetailFragment> blogDetailFragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_detail);
        ButterKnife.bind(this);
        initData();
        setupPager();
    }

    public void initData() {
        Trend trend = (Trend) getIntent().getSerializableExtra(AppConst.BlogDetailActivityConst.KEY_TREND);
        blogs = trend.getBlogs();
        position = getIntent().getIntExtra(AppConst.BlogDetailActivityConst.KEY_POSITION, 0);
    }

    public void setupPager() {
        blogDetailFragmentList = new ArrayList<>();
        for (Blog blog : blogs) {
            blogDetailFragmentList.add(BlogDetailFragment.newInstance());
        }
        vpFragment.setOffscreenPageLimit(blogs.size());
        vpFragment.setAdapter(new BlogPagerAdapter(getSupportFragmentManager(), blogDetailFragmentList));
        vpFragment.clearOnPageChangeListeners();
        vpFragment.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switchPageWithLoadData(position);
            }
        });
        vpFragment.setCurrentItem(position);
        switchPageWithLoadData(position);
    }

    private void switchPageWithLoadData(int position) {
        BlogDetailFragment blogDetailFragment = blogDetailFragmentList.get(position);
        blogDetailFragment.setBlog(blogs.get(position));
        blogDetailFragment.loadData();
    }


}
