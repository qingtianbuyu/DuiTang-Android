package com.duitang.view.menu;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.entity.RecyclerMenuItem;
import com.duitang.util.ImageLoaderHelper;

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

    private OnItemClickListener onItemClickListener;
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
        } else if (viewType == RecyclerMenuItem.KEY_TYPE_ORDER) {
            return new OrderViewHolder(inflate(parent, R.layout.item_recycler_me_menu_order));
        } else if (viewType == RecyclerMenuItem.KEY_TYPE_ICON) {
            return new UserIconViewHolder(inflate(parent, R.layout.item_recycler_me_menu_user_icon));
        }
        return null;
    }

    private View inflate(ViewGroup parent, int resId) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == RecyclerMenuItem.KEY_TYPE_NORMAL) {
            SimpleIconTextHolder simpleIconTextHolder = (SimpleIconTextHolder) holder;
            RecyclerMenuItem recyclerMenuItem = recyclerMenuItems.get(holder.getLayoutPosition());
            simpleIconTextHolder.ivIcon.setImageResource(recyclerMenuItem.resId);
            simpleIconTextHolder.tvLabel.setText(recyclerMenuItem.text);
            simpleIconTextHolder.llRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(holder.getLayoutPosition());
                    }
                }
            });
        } else if (itemViewType == RecyclerMenuItem.KEY_TYPE_ORDER) {
            OrderViewHolder simpleIconTextHolder = (OrderViewHolder) holder;
            RecyclerMenuItem recyclerMenuItem = recyclerMenuItems.get(holder.getLayoutPosition());
            simpleIconTextHolder.ivIcon.setImageResource(recyclerMenuItem.resId);
            simpleIconTextHolder.tvLabel.setText(recyclerMenuItem.text);
            simpleIconTextHolder.llRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(holder.getLayoutPosition());
                    }
                }
            });
        } else if (itemViewType == RecyclerMenuItem.KEY_TYPE_ICON) {
            UserIconViewHolder simpleIconTextHolder = (UserIconViewHolder) holder;
            String logoUrl = "http://wx.qlogo.cn/mmopen/iaVibjjgfRjm07lQLbxHzkeXP45nJTECTiarLf8RP1tPDtDICnAdiclvcxgHOibxKdo4S3dGR90yeM3MFaMialsQSNU9vGzJickEhMj/0";
            ImageLoaderHelper.loadImageViewWithCircle(logoUrl, simpleIconTextHolder.ivIcon);
            simpleIconTextHolder.llRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(holder.getLayoutPosition());
                    }
                }
            });
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
        @BindView(R.id.ll_root)
        View llRoot;

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


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onItemClick(int position);
    }

    static class OrderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_label)
        TextView tvLabel;
        @BindView(R.id.iv_arrow)
        ImageView ivArrow;
        @BindView(R.id.ll_root)
        LinearLayout llRoot;
        @BindView(R.id.btn_wait_pay)
        Button btnWaitPay;
        @BindView(R.id.btn_wait_send)
        Button btnWaitSend;
        @BindView(R.id.btn_wait_receive)
        Button btnWaitReceive;
        @BindView(R.id.btn_wait_rate)
        Button btnWaitRate;

        OrderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class UserIconViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_desc)
        TextView tvDesc;
        @BindView(R.id.ll_root)
        RelativeLayout llRoot;

        UserIconViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
