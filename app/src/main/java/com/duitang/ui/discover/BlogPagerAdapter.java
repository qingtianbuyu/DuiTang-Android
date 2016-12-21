package com.duitang.ui.discover;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/21 下午8:48
 */
public class BlogPagerAdapter extends FragmentPagerAdapter {
    public List<BlogDetailFragment> blogDetailFragmentList;

    public BlogPagerAdapter(FragmentManager fm, List<BlogDetailFragment> blogDetailFragmentList) {
        super(fm);
        this.blogDetailFragmentList = blogDetailFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return blogDetailFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return blogDetailFragmentList == null ? 0 : blogDetailFragmentList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_UNCHANGED;
    }
}
