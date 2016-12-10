package com.duitang.ui.main;

import android.content.res.Resources;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duitang.R;
import com.duitang.entity.ContentGroup;
import com.duitang.entity.ContentGroupItem;
import com.duitang.util.ImageLoaderHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/10 上午10:15
 */
public class DiscoverAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_SEACTION = 1;
    private static final int TYPE_ITEM = 2;


    List<ContentGroup> dataList;
    List<ContentGroupItem> dataListCp = new ArrayList<>();
    List<Integer> groupPositions;

    public DiscoverAdapter(List<ContentGroup> dataList) {
        this.dataList = dataList;
        groupPositions = new ArrayList<>();
        initGroupPosition();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_HEADER) {
            return new HeaderViewHolder(inflate(parent, R.layout.item_recycler_discover_header));
        } else if (viewType == TYPE_SEACTION) {
            return new SectionViewHolder(inflate(parent, R.layout.item_recycler_discover_section));
        }
        return new ContentViewHolder(inflate(parent, R.layout.item_recycler_discover_content));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == TYPE_ITEM) {
            int layoutPosition = holder.getLayoutPosition();
            //计算当前处于那个Section
            int groupPosition = getGroupPosition(layoutPosition);
            int itemPosition = getChildPosition(layoutPosition);
            ContentViewHolder contentViewHolder = (ContentViewHolder) holder;
            ContentGroupItem contentGroupItem = dataListCp.get(groupPosition);
            contentViewHolder.tvName.setText(contentGroupItem.getName());
            ImageLoaderHelper.loadImageView(contentViewHolder.tvName.getContext(), contentGroupItem.getIcon_url(), contentViewHolder.iv);
            Log.d("TAG", position+"----");
        }
    }

    private int getChildPosition(int position) {
        int section = getGroupPosition(position);
        int absGroupPosition = groupPositions.get(section);
        int childPositionInGroup = absGroupPosition - position - 1;
        return childPositionInGroup;
    }


    int getGroupPosition(int position) {
        int index = 0;
        for (int i = 0; i < dataList.size(); i++) {
            index += (dataList.get(i).getGroup_items().size() + 1);
            if (position <= index) {
                return i;
            }
        }
        return index;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        } else if (groupPositions.contains(position)) {
            return TYPE_SEACTION;
        }

        return TYPE_ITEM;
    }

    @Override
    public int getItemCount() {
        int count = 1;
        for (int i = 0; i < dataList.size(); i++) {
            ContentGroup contentGroup = dataList.get(i);
            if (!contentGroup.getGroup_id().contains("category")) {
                continue;
            }
            if (i != dataList.size() - 1) {
                count += 1;
            }
            count += getChildCount(i);
        }
        return count;
    }


    @Override
    public void onAttachedToRecyclerView(final RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    RecyclerView.Adapter adapter = recyclerView.getAdapter();
                    if (isFullSpanType(adapter.getItemViewType(position))) {
                        return gridLayoutManager.getSpanCount();
                    }
                    return 1;
                }
            });
        }
    }

    private boolean isFullSpanType(int type) {
        return type == TYPE_HEADER || type == TYPE_SEACTION;
    }


    public void initGroupPosition() {
        groupPositions.clear();
        dataListCp.clear();
        int groupPosition = 0;
        for (int i = 0; i < dataList.size(); i++) {
            ContentGroup contentGroup = dataList.get(i);
            if (!contentGroup.getGroup_id().contains("category")) {
                continue;
            }
            groupPosition += (getChildCount(i) + 1);
            groupPositions.add(groupPosition);

            dataListCp.addAll(contentGroup.getGroup_items());
            dataListCp.add(new ContentGroupItem());
        }
    }

    /**
     * 获取内容个数
     *
     * @param groupPosition
     * @return
     */

    public int getChildCount(int groupPosition) {
        List<ContentGroupItem> group_items = dataList.get(groupPosition).getGroup_items();
        return group_items == null ? 0 : group_items.size();
    }

    public View inflate(ViewGroup parent, int resId) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    /**
     * 顶部viewHolder
     */
    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ll_container_item_left)
        LinearLayout llContainerItemLeft;
        @BindView(R.id.ll_container_item_right)
        LinearLayout llContainerItemRight;
        @BindView(R.id.ll_top_hot)
        LinearLayout llTopHot;
        @BindView(R.id.ll_top_article)
        LinearLayout llTopArticle;
        @BindView(R.id.ll_top_bag)
        LinearLayout llTopBag;
        @BindView(R.id.ll_content_container)
        LinearLayout llContentContainer;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class SectionViewHolder extends RecyclerView.ViewHolder {

        SectionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv_name)
        TextView tvName;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
