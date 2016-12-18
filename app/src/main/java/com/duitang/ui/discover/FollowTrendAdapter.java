package com.duitang.ui.discover;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.utils.ScreenUtils;
import com.blankj.utilcode.utils.SizeUtils;
import com.duitang.R;
import com.duitang.entity.Blog;
import com.duitang.entity.Trend;
import com.duitang.entity.User;
import com.duitang.util.ImageLoaderHelper;
import com.duitang.view.refresh.OnRecyclerItemClickListener;
import com.duitang.view.refresh.SpaceItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FollowTrendAdapter extends RecyclerView.Adapter<FollowTrendAdapter.BaseTrendViewHolder> {
    public static final int KEY_ARTICLE = 1001;
    public static final int KEY_ALBUM = 1002;

    List<Trend> trendList;
    SpaceItemDecoration decor;
    OnTrendItemClickListener onTrendItemClickListener;

    public FollowTrendAdapter(List<Trend> trendList) {
        this.trendList = trendList;
    }

    public void setOnTrendItemClickListener(OnTrendItemClickListener onTrendItemClickListener) {
        this.onTrendItemClickListener = onTrendItemClickListener;
    }

    private View inflate(int resId, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(resId, parent, false);
    }

    @Override
    public BaseTrendViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int verticalSpacing = SizeUtils.dp2px(parent.getContext(), 10);
        decor = new SpaceItemDecoration(verticalSpacing);
        BaseTrendViewHolder baseTrendViewHolder = null;
        if (viewType == KEY_ARTICLE) {
            baseTrendViewHolder = new ArticleViewHolder(inflate(R.layout.item_recycler_article, parent), onTrendItemClickListener, trendList);
        } else if (viewType == KEY_ALBUM) {
            final AlbumViewHolder albumViewHolder = new AlbumViewHolder(inflate(R.layout.item_recycler_trend_album, parent), onTrendItemClickListener, trendList);
            baseTrendViewHolder = albumViewHolder;
        } else {
            View inflate = inflate(R.layout.item_recycler_follow_trends, parent);
            baseTrendViewHolder = new BaseTrendViewHolder(inflate, onTrendItemClickListener, trendList);
        }
        return baseTrendViewHolder;
    }

    @Override
    public void onBindViewHolder(final BaseTrendViewHolder holder, int position) {
        int layoutPosition = holder.getLayoutPosition();
        Trend trend = trendList.get(layoutPosition);
        holder.tvAddTime.setText(trend.getAdd_datetime_tsStr());
        User user = trend.getPublisher();
        holder.tvName.setText(user.getUsername());
        ImageLoaderHelper.loadImageViewWithCircle(user.getAvatar(), holder.ivAvatar);
        String title = "";
        int itemViewType = getItemViewType(position);
        if (itemViewType == KEY_ALBUM) {
            title = "<font color='#666666' size='15'>更新了专辑&nbsp;</font><font color='#333333' size='15'>" + trend.getTitle() + "</font>";
            AlbumViewHolder albumViewHolder = (AlbumViewHolder) holder;
            Context context = albumViewHolder.recycler.getContext();

            // TODO: 2016/12/18 总觉得设置LayoutParams太屌丝
            int screenWidth = ScreenUtils.getScreenWidth(context);
            if (trend.getBlogs().size() == 2 || trend.getBlogs().size() == 4) {
                albumViewHolder.recycler.setLayoutManager(new GridLayoutManager(context, 2));
                ViewGroup.LayoutParams layoutParams = albumViewHolder.recycler.getLayoutParams();
                int itemMargin = (int) ((screenWidth - SizeUtils.dp2px(context, 60) - SizeUtils.dp2px(context, 90) * 3 - SizeUtils.dp2px(context, 15)) * 0.5);
                layoutParams.width = SizeUtils.dp2px(context, 90) * 2 + itemMargin;
            } else {
                ViewGroup.LayoutParams layoutParams = albumViewHolder.recycler.getLayoutParams();
                layoutParams.width = screenWidth - SizeUtils.dp2px(context, 60) - SizeUtils.dp2px(context, 15);
                albumViewHolder.recycler.setLayoutManager(new GridLayoutManager(context, 3));
            }

            int tag = (albumViewHolder.recycler.getTag() != null) ? (int) albumViewHolder.recycler.getTag() : 0;
            if (tag == 0) {
                albumViewHolder.recycler.addItemDecoration(decor);
                albumViewHolder.recycler.setTag(trend.getId());
            }
            albumViewHolder.recycler.setAdapter(new FollowTrendAlbumAdapter(trend.getBlogs()));

        } else if (itemViewType == KEY_ARTICLE) {
            title = "<font color='#666666' size='15'>发布了文章 &nbsp;</font><font color='#333333' size='15'>" + trend.getTitle() + "</font>";
            ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
            ImageLoaderHelper.loadImageView(trend.getPhotos().get(0).getPath(), articleViewHolder.ivArticle);
        }
        holder.tvTitle.setText(Html.fromHtml(title));
    }

    @Override
    public int getItemViewType(int position) {
        Trend trend = trendList.get(position);
        if (TextUtils.equals(trend.getType(), "ARTICLE")) {
            return KEY_ARTICLE;
        } else if (TextUtils.equals(trend.getType(), "ALBUM")) {
            return KEY_ALBUM;
        }
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return trendList == null ? 0 : trendList.size();
    }

    static class BaseTrendViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.iv_avatar)
        ImageView ivAvatar;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_add_time)
        TextView tvAddTime;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        public OnTrendItemClickListener onTrendItemClickListener;
        List<Trend> trendList;

        public BaseTrendViewHolder(View view, OnTrendItemClickListener onTrendItemClickListener, List<Trend> trendList) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);
            this.onTrendItemClickListener = onTrendItemClickListener;
            this.trendList = trendList;
        }

        @Override
        public void onClick(View view) {
            if (onTrendItemClickListener != null) {
                int layoutPosition = getLayoutPosition();
                onTrendItemClickListener.onItemClick(layoutPosition);
            }
        }
    }

    static class ArticleViewHolder extends BaseTrendViewHolder {
        @BindView(R.id.iv_article)
        ImageView ivArticle;

        ArticleViewHolder(View view, OnTrendItemClickListener onTrendItemClickListener, List<Trend> trendList) {
            super(view, onTrendItemClickListener, trendList);
            ButterKnife.bind(this, view);
        }
    }

    static class AlbumViewHolder extends BaseTrendViewHolder {
        @BindView(R.id.recycler)
        RecyclerView recycler;

        AlbumViewHolder(View view, final OnTrendItemClickListener onTrendItemClickListener, final List<Trend> trendList) {
            super(view, onTrendItemClickListener, trendList);
            ButterKnife.bind(this, view);
            recycler.addOnItemTouchListener(new OnRecyclerItemClickListener(recycler) {
                @Override
                public void onItemClick(RecyclerView.ViewHolder vh) {
                    super.onItemClick(vh);
                    if (onTrendItemClickListener == null) return;
                    int layoutPosition = getLayoutPosition();
                    Trend trend = trendList.get(layoutPosition);
                    onTrendItemClickListener.onItemBlogClick(trend, trend.getBlogs().get(vh.getLayoutPosition()));
                }
            });
        }
    }

    public interface OnTrendItemClickListener {
        void onItemClick(int layoutPosition);

        void onItemBlogClick(Trend trend, Blog blog);
    }

}
