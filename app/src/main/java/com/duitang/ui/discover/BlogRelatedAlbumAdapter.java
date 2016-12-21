package com.duitang.ui.discover;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ScreenUtils;
import com.blankj.utilcode.utils.SizeUtils;
import com.duitang.R;
import com.duitang.entity.Album;
import com.duitang.entity.BlogDetail;
import com.duitang.entity.Photo;
import com.duitang.util.ImageLoaderHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/21 下午9:29
 */
public class BlogRelatedAlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int KEY_HEADER = 0;
    private static final int KEY_ITEM = 1;

    private final BlogDetail detail;

    public BlogRelatedAlbumAdapter(BlogDetail detail) {
        this.detail = detail;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == KEY_HEADER) {
            return new BlogHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog_related_album_header, parent, false));
        }
        return new BlogItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_blog_related_album_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        if (itemViewType == KEY_HEADER) {
            BlogHolder blogHolder = (BlogHolder) holder;
            Photo photo = detail.getPhoto();
            Context context = blogHolder.iv.getContext();
            int screenWidth = ScreenUtils.getScreenWidth(context);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) blogHolder.iv.getLayoutParams();
            int ivWidth = screenWidth - 2 * layoutParams.leftMargin;
            int width = photo.getWidth();
            int height = photo.getHeight();
            int ivHeight = (int) ((height * ivWidth * 0.9f) / (width * 1.0f));
            layoutParams.height = ivHeight;
            ImageLoaderHelper.loadImageView(photo.getPath(), blogHolder.iv);
            blogHolder.tvMsg.setText(detail.getMsg());
            blogHolder.tvTitle.setText(detail.getSender().getUsername());
            blogHolder.tvUsername.setText("收藏到 " + detail.getAlbum().getName());
            blogHolder.tvCreateTime.setText(detail.getAdd_datetime_pretty());
            ImageLoaderHelper.loadImageViewWithCircle(detail.getSender().getAvatar(), blogHolder.ivAvatar);
        } else {
            BlogItemHolder blogItemHolder = (BlogItemHolder) holder;
            List<Album> related_albums = detail.getRelated_albums();
            int currentPosition = holder.getLayoutPosition() - 1;
            Album album = related_albums.get(currentPosition);
            blogItemHolder.tvTitle.setText(album.getName());
            blogItemHolder.tvUsername.setText("by " + album.getUser().getUsername());
            ImageLoaderHelper.loadImageView(album.getCovers().get(0), blogItemHolder.iv);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return KEY_HEADER;
        }
        return KEY_ITEM;
    }

    @Override
    public int getItemCount() {
        int albumsCount = detail.getRelated_albums() == null ? 0 : detail.getRelated_albums().size();
        return albumsCount + 1;
    }

    static class BlogHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.iv_avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_username)
        TextView tvUsername;
        @BindView(R.id.tv_create_time)
        TextView tvCreateTime;

        @BindView(R.id.tv_msg)
        TextView tvMsg;

        BlogHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    static class BlogItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_username)
        TextView tvUsername;

        BlogItemHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
