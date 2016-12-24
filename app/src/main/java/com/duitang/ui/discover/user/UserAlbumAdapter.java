package com.duitang.ui.discover.user;

import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duitang.R;
import com.duitang.entity.Album;
import com.duitang.util.ImageLoaderHelper;

import java.util.List;

import butterknife.BindView;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/24 下午5:20
 */
public class UserAlbumAdapter extends BaseQuickAdapter<Album, BaseViewHolder> {


    public UserAlbumAdapter(List<Album> data) {
        super(R.layout.item_user_album, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Album album) {
        helper.setText(R.id.tv_name, album.getName());
        helper.setText(R.id.tv_count_fav, album.getCountAndFacCount());
        helper.setVisible(R.id.tv_fav_label, album.isAlbumZX());
        ImageView ivCover = helper.getView(R.id.iv_cover);
        ImageLoaderHelper.loadImageView(album.getCovers().get(0), ivCover);
    }
}
