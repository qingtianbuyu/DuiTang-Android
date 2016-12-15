package com.duitang.ui.main;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.base.AppConst;
import com.duitang.entity.Topic;
import com.duitang.util.ImageLoaderHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午7:02
 */
public class TopicAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Topic> topics;

    public TopicAdapter(List<Topic> topics) {
        this.topics = topics;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == AppConst.TopicConst.FirstType) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_topic_first, parent, false);
            return new FirstViewHolder(view);
        } else if (viewType == AppConst.TopicConst.LargeType) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_topic_large, parent, false);
            return new LargeViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_topic_small, parent, false);
            return new SmallViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == AppConst.TopicConst.FirstType) {
            FirstViewHolder firstViewHolder = (FirstViewHolder) holder;
            Topic topic = topics.get(firstViewHolder.getLayoutPosition());
            ImageLoaderHelper.loadImageView(topic.getImage_url(), firstViewHolder.imageView);
            firstViewHolder.tvDescription.setText(topic.getDescription());

        } else if (itemViewType == AppConst.TopicConst.LargeType) {
            LargeViewHolder largeViewHolder = (LargeViewHolder) holder;
            Topic topic = topics.get(largeViewHolder.getLayoutPosition());
            ImageLoaderHelper.loadImageView(topic.getImage_url(), largeViewHolder.imageView);
            largeViewHolder.tvCategory.setText(topic.getContent_category());
            largeViewHolder.tvDescription.setText(topic.getDescription());
            largeViewHolder.tvNickname.setText(topic.getNickname());
            largeViewHolder.tvTitle.setText(topic.getEnabled_at_str());
        } else {
            SmallViewHolder largeViewHolder = (SmallViewHolder) holder;
            Topic topic = topics.get(largeViewHolder.getLayoutPosition());
            ImageLoaderHelper.loadImageView(topic.getImage_url(), largeViewHolder.imageView);
            largeViewHolder.tvCategory.setText(topic.getContent_category());
            largeViewHolder.tvDescription.setText(topic.getDescription());
            largeViewHolder.tvNickname.setText(topic.getNickname());
            largeViewHolder.tvDynamicInfo2.setText(topic.getDynamic_info2());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return AppConst.TopicConst.FirstType;
        }

        Topic topic = topics.get(position);
        if (TextUtils.equals(topic.getStyle(), AppConst.TopicConst.Large)) {
            return AppConst.TopicConst.LargeType;
        }
        return AppConst.TopicConst.SmallType;
    }

    @Override
    public int getItemCount() {
        return topics == null ? 0 : topics.size();
    }

    static class LargeViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.tv_nickname)
        TextView tvNickname;

        LargeViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class FirstViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.tv_description)
        TextView tvDescription;

        FirstViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class SmallViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_description)
        TextView tvDescription;
        @BindView(R.id.tv_category)
        TextView tvCategory;
        @BindView(R.id.tv_nickname)
        TextView tvNickname;
        @BindView(R.id.tv_dynamic_info2)
        TextView tvDynamicInfo2;
        @BindView(R.id.imageView)
        ImageView imageView;

        SmallViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
