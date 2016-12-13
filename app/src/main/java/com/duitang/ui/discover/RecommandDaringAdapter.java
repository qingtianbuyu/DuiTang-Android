package com.duitang.ui.discover;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duitang.R;
import com.duitang.entity.User;

import java.util.List;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/13 下午10:44
 */
public class RecommandDaringAdapter extends BaseQuickAdapter<User, BaseViewHolder> {

    public RecommandDaringAdapter(List<User> data) {
        super(R.layout.item_recycler_recommand_daring, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, User user) {

    }
}
