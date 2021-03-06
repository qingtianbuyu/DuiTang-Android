package com.duitang.http;

import com.duitang.base.ApiService;
import com.duitang.base.AppConst;
import com.duitang.base.BaseResult;
import com.duitang.base.ObjectList;
import com.duitang.entity.Album;
import com.duitang.entity.AlbumData;
import com.duitang.entity.Favorite;
import com.duitang.entity.Topic;
import com.duitang.util.RetrofitUtil;

import retrofit2.Call;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午1:27
 */
public class HomeHttp {

    public static void loadBannerList(int start, RetrofitUtil.RequestCallBack<ObjectList<Topic>> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<ObjectList<Topic>>> call = service.loadTopics(start);
        RetrofitUtil.request(call, callBack);
    }

    public static void listAlbumDetail(String albumId, RetrofitUtil.RequestCallBack<Album> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<Album>> call = service.listAlbumDetail(albumId, AppConst.AlbumConst.includeFieleds);
        RetrofitUtil.request(call, callBack);
    }

    public static void listAlbumList(String targetId, int userId, int start, RetrofitUtil.RequestCallBack<ObjectList<AlbumData>> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<ObjectList<AlbumData>>> call = service.listAlbumList(targetId, userId, start);
        RetrofitUtil.request(call, callBack);
    }

    public static void albumListByUser(int userId, int start, RetrofitUtil.RequestCallBack<ObjectList<Album>> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<ObjectList<Album>>> call = service.albumListByUser(userId, start);
        RetrofitUtil.request(call, callBack);
    }

    public static void loadArticle(String articleId, RetrofitUtil.RequestCallBack<AlbumData> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<AlbumData>> call = service.loadArticle(articleId);
        RetrofitUtil.request(call, callBack);
    }

    public static void favoriteList(int userId,int start, RetrofitUtil.RequestCallBack<ObjectList<Favorite>> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<ObjectList<Favorite>>> call = service.favoriteList(userId,start);
        RetrofitUtil.request(call, callBack);
    }
}
