package com.duitang.ui.discover;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.duitang.R;
import com.duitang.entity.Blog;
import com.duitang.util.ImageLoaderHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowTrendAlbumAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Blog> blogs;

    public FollowTrendAlbumAdapter(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FollowTrendAlbumHolder(inflate(R.layout.item_recycler_trend_album_image, parent));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int layoutPosition = holder.getLayoutPosition();
        FollowTrendAlbumHolder followTrendAlbumHolder = (FollowTrendAlbumHolder) holder;
        Blog blog = blogs.get(layoutPosition);
        ImageLoaderHelper.loadImageView(blog.getPhoto().getPath(), followTrendAlbumHolder.ivAlbum);
    }

    @Override
    public int getItemCount() {
        return blogs == null ? 0 : blogs.size();
    }


    private View inflate(int resId, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    static class FollowTrendAlbumHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_album)
        ImageView ivAlbum;

        FollowTrendAlbumHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
