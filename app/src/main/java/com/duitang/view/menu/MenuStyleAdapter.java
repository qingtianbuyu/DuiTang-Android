package com.duitang.view.menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.entity.RecyclerMenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/10 下午4:32
 */
public class MenuStyleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    public List<RecyclerMenuItem> recyclerMenuItems;

    public MenuStyleAdapter(List<RecyclerMenuItem> recyclerMenuItems) {
        this.recyclerMenuItems = recyclerMenuItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == RecyclerMenuItem.KEY_TYPE_NORMAL) {
            return new SimpleIconTextHolder(inflate(parent, R.layout.item_recycler_me_menu_item));
        } else if (viewType == RecyclerMenuItem.KEY_BLANK_DIVER) {
            return new SimpleDividerHolder(inflate(parent, R.layout.item_recycler_me_divider));
        }
        return null;
    }

    private View inflate(ViewGroup parent, int resId) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == RecyclerMenuItem.KEY_TYPE_NORMAL) {
            SimpleIconTextHolder simpleIconTextHolder = (SimpleIconTextHolder) holder;
            RecyclerMenuItem recyclerMenuItem = recyclerMenuItems.get(holder.getLayoutPosition());
            simpleIconTextHolder.ivIcon.setImageResource(recyclerMenuItem.resId);
            simpleIconTextHolder.tvLabel.setText(recyclerMenuItem.text);
        }
    }

    @Override
    public int getItemCount() {
        return recyclerMenuItems == null ? 0 : recyclerMenuItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        RecyclerMenuItem recyclerMenuItem = recyclerMenuItems.get(position);
        return recyclerMenuItem.type;
    }

    static class SimpleIconTextHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_label)
        TextView tvLabel;
        @BindView(R.id.iv_arrow)
        ImageView ivArrow;

        SimpleIconTextHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class SimpleDividerHolder extends RecyclerView.ViewHolder {


        SimpleDividerHolder(View view) {
            super(view);
        }
    }
}
