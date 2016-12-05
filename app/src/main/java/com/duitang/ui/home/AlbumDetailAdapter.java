package com.duitang.ui.home;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.duitang.entity.Album;
import com.duitang.entity.AlbumData;

import java.util.List;

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
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        int headerCount = 1;
        int itemSize = dataList == null ? 0 : dataList.size();
        return headerCount + itemSize;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
