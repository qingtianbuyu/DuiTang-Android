package com.duitang.ui.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ScreenUtils;
import com.blankj.utilcode.utils.SizeUtils;
import com.duitang.R;
import com.duitang.base.AppConst;
import com.duitang.entity.Album;
import com.duitang.entity.AlbumData;
import com.duitang.util.ImageLoaderHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/5 下午11:11
 */
public class AlbumDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private List<AlbumData> dataList;
    private Album album;


    public AlbumDetailAdapter(List<AlbumData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item;
        if (viewType == AppConst.AlbumDetailAdapterConst.ItemTypeHeader) {
            item = inflate(parent, R.layout.item_recycler_album_detail_header);
            return new HeaderViewHolder(item);
        }

        item = inflate(parent, R.layout.item_recycler_album_detail_content);
        return new ContentViewHolder(item);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == AppConst.AlbumDetailAdapterConst.ItemTypeHeader) {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.tvTitle.setText(album.getName());
            headerViewHolder.tvAlbumCount.setText(album.getCount() + "张图片");
            ImageLoaderHelper.loadImageViewWithCircle(((HeaderViewHolder) holder).tvAlbumCount.getContext(), album.getUser().getAvatar(), headerViewHolder.ivAvatar);
            headerViewHolder.tvAlbumName.setText(album.getUser().getUsername());
        } else {
            ContentViewHolder cholder = (ContentViewHolder) holder;
            int layoutPosition = holder.getLayoutPosition() - 1;
            AlbumData albumData = dataList.get(layoutPosition);
            // get width height in px
            int width = albumData.getPhoto().getWidth();
            int height = albumData.getPhoto().getHeight();
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cholder.ivPhoto.getLayoutParams();
            Context context = cholder.ivPhoto.getContext();
            int screenWidth = ScreenUtils.getScreenWidth(context);
            int margin = SizeUtils.dp2px(context, 12);
            float itemWith = (screenWidth - 3 * margin) * 0.5f;
            float itemHeight = height * (itemWith / width);
            layoutParams.width = (int) itemWith;
            layoutParams.height = (int) itemHeight;
            cholder.ivPhoto.setLayoutParams(layoutParams);
            LinearLayout.LayoutParams containerLp = (LinearLayout.LayoutParams) cholder.llContainer.getLayoutParams();
            containerLp.width = (int) itemWith;
            if (layoutPosition % 2 == 0) {
                containerLp.leftMargin = margin;
            } else {
                containerLp.leftMargin = margin / 2;
            }

            containerLp.topMargin = margin;

            ImageLoaderHelper.loadImageView(((ContentViewHolder) holder).ivPhoto.getContext(), albumData.getPhoto().getPath(), ((ContentViewHolder) holder).ivPhoto);
            cholder.tvLikeCount.setText(albumData.getLike_count() + "");
            cholder.tvMsg.setText(albumData.getMsg());
        }
    }

    @Override
    public int getItemCount() {
        int headerCount = 1;
        int itemSize = dataList == null ? 0 : dataList.size();
        return headerCount + itemSize;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return AppConst.AlbumDetailAdapterConst.ItemTypeHeader;
        }
        return AppConst.AlbumDetailAdapterConst.ItemTypeContent;
    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(holder.getLayoutPosition() == 0);
        }
    }

    private View inflate(ViewGroup parent, int resId) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }


    public void setAlbum(Album album) {
        this.album = album;
    }

    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_album_count)
        TextView tvAlbumCount;
        @BindView(R.id.iv_avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_album_name)
        TextView tvAlbumName;

        HeaderViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class ContentViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_photo)
        ImageView ivPhoto;
        @BindView(R.id.tv_msg)
        TextView tvMsg;
        @BindView(R.id.tv_like_count)
        TextView tvLikeCount;
        @BindView(R.id.ll_contener)
        LinearLayout llContainer;

        ContentViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
