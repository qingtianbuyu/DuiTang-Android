package com.duitang.ui.discover;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.entity.ColumnData;
import com.duitang.entity.TopicData;
import com.duitang.util.ImageLoaderHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/25 下午2:12
 */
public class ClubAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int KEY_TYPE_TOPIC = 0;
    private static final int KEY_TYPE_COLUMN = 1;


    private List<TopicData> topicDataList;
    private List<ColumnData> columnDataList;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == KEY_TYPE_COLUMN) {
            return new ClubColumnHolder(inflate(R.layout.item_recycler_club_column, parent));
        } else if (KEY_TYPE_TOPIC == viewType) {
            return new ClubTopicHolder(inflate(R.layout.item_recycler_club_topic, parent));
        }
        return null;
    }

    private View inflate(int resId, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (KEY_TYPE_COLUMN == itemViewType) {
            ClubColumnHolder topicHolder = (ClubColumnHolder) holder;
            ColumnData topicData = columnDataList.get(holder.getLayoutPosition());
            topicHolder.tvDynaicInfo.setText(topicData.getDynamic_info());
            topicHolder.tvPinTagName.setText(topicData.getPin_tag_name());
            topicHolder.tvTitle.setText(topicData.getTitle());
            topicHolder.tvShortDesc.setText(topicData.getShort_desc());
            ImageLoaderHelper.loadImageView(topicData.getPhotos().get(0).getPath(), topicHolder.ivPhoto);
        } else if (KEY_TYPE_TOPIC == itemViewType) {
            ClubTopicHolder topicHolder = (ClubTopicHolder) holder;
            TopicData topicData = topicDataList.get(holder.getLayoutPosition() - getColumnCount());
            topicHolder.tvDynaicInfo.setText(topicData.getDynamic_info2());
            topicHolder.tvCommentCount.setText(topicData.getComment_count() + "");
            topicHolder.tvContent.setText(topicData.getContent());
            topicHolder.tvClubName.setText(topicData.getSender().getUsername() + " ~ " + topicData.getClub().getName());
            topicHolder.ivPhoto.setVisibility(View.VISIBLE);
            if (topicData.getPhotos() != null && topicData.getPhotos().size() > 0) {
                ImageLoaderHelper.loadImageView(topicData.getPhotos().get(0).getPath(), topicHolder.ivPhoto);
            } else {
                topicHolder.ivPhoto.setVisibility(View.GONE);
            }

        }
    }


    @Override
    public int getItemViewType(int position) {
        if (position < getColumnCount()) {
            return KEY_TYPE_COLUMN;
        } else if (position < (getTopicCount() + getColumnCount())) {
            return KEY_TYPE_TOPIC;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        int topicCount = getTopicCount();
        int columnCount = getColumnCount();
        return topicCount + columnCount;
    }

    private int getColumnCount() {
        return (columnDataList == null) ? 0 : columnDataList.size();
    }

    private int getTopicCount() {
        return topicDataList == null ? 0 : topicDataList.size();
    }

    public void setTopicDataList(List<TopicData> topicDataList) {
        this.topicDataList = topicDataList;
    }

    public void setColumnDataList(List<ColumnData> columnDataList) {
        this.columnDataList = columnDataList;
    }

    static class ClubColumnHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_pin_tag_name)
        TextView tvPinTagName;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.iv_photo)
        ImageView ivPhoto;
        @BindView(R.id.tv_short_desc)
        TextView tvShortDesc;
        @BindView(R.id.tv_dynaic_info)
        TextView tvDynaicInfo;

        ClubColumnHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ClubTopicHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_comment_count)
        TextView tvCommentCount;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.iv_photo)
        ImageView ivPhoto;
        @BindView(R.id.tv_club_name)
        TextView tvClubName;
        @BindView(R.id.tv_dynaic_info)
        TextView tvDynaicInfo;

        ClubTopicHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
