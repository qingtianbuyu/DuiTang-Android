package com.duitang.ui.discover.user;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duitang.R;
import com.duitang.entity.Favorite;
import com.duitang.util.ImageLoaderHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/24 下午5:53
 */
public class UserFavoriteAdapter extends BaseQuickAdapter<Favorite, BaseViewHolder> {

    public UserFavoriteAdapter(List<Favorite> data) {
        super(R.layout.item_recycler_user_favorite, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Favorite favorite) {
        helper.setText(R.id.tv_name, favorite.getTitle());
        helper.setText(R.id.tv_fav_count, favorite.getBlog_count() + "");
        String type = "album".equals(favorite.getType()) ? "专辑" : "";
        helper.setText(R.id.tv_description, type + " | " + favorite.getSender().getUsername());
        helper.setText(R.id.tv_create_time, favorite.getAdd_datetime());

        ImageView iv1 = helper.getView(R.id.iv1);
        ImageView iv2 = helper.getView(R.id.iv2);
        ImageView iv3 = helper.getView(R.id.iv3);
        ImageView iv4 = helper.getView(R.id.iv4);

        ImageLoaderHelper.loadImageView(favorite.getPhotos().get(0).getPath(), iv1);
        ImageLoaderHelper.loadImageView(favorite.getPhotos().get(1).getPath(), iv2);
        ImageLoaderHelper.loadImageView(favorite.getPhotos().get(2).getPath(), iv3);
        ImageLoaderHelper.loadImageView(favorite.getPhotos().get(3).getPath(), iv4);
    }

}
