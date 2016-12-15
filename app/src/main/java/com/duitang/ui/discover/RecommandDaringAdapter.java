package com.duitang.ui.discover;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duitang.R;
import com.duitang.entity.User;
import com.duitang.util.ImageLoaderHelper;

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
        baseViewHolder.setText(R.id.tv_name, user.getUsername());
        baseViewHolder.setText(R.id.tv_identity_info, user.getIdentity_info());
        baseViewHolder.setText(R.id.tv_description, user.getShort_description());
        ImageView ivAvator = baseViewHolder.getView(R.id.iv_avator);
        ImageLoaderHelper.loadImageViewWithCircle(user.getAvatar(), ivAvator);
        baseViewHolder.setVisible(R.id.iv_certificate, user.getIdentity().contains("personal_certify"));
        baseViewHolder.setBackgroundRes(R.id.btn_follow, R.drawable.selector_button_followed);
        baseViewHolder.setTextColor(R.id.btn_follow, Color.parseColor("#74D197"));
        setFollowButton(baseViewHolder, user);
        baseViewHolder.addOnClickListener(R.id.btn_follow);
    }

    private void setFollowButton(BaseViewHolder baseViewHolder, User user) {
        baseViewHolder.setText(R.id.btn_follow, "已关注");
        if (user.getRelationship() == 0) {
            baseViewHolder.setTextColor(R.id.btn_follow, Color.WHITE);
            baseViewHolder.setBackgroundRes(R.id.btn_follow, R.drawable.selector_button_unfollowed);
            baseViewHolder.setText(R.id.btn_follow, "关注");
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position, List<Object> payloads) {
        if (payloads == null || payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            Bundle payload = (Bundle) payloads.get(0);
            User user = mData.get(position);
            setFollowButton(holder, user);
        }
    }
}
