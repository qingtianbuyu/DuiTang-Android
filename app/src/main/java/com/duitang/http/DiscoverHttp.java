package com.duitang.http;

import com.duitang.base.ApiService;
import com.duitang.base.BaseResult;
import com.duitang.base.ObjectList;
import com.duitang.entity.BlogDetail;
import com.duitang.entity.ContentGroup;
import com.duitang.entity.Trend;
import com.duitang.entity.User;
import com.duitang.util.RetrofitUtil;

import java.util.List;

import retrofit2.Call;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/10 上午10:04
 */
public class DiscoverHttp {

    public static void loadContentList(RetrofitUtil.RequestCallBack<List<ContentGroup>> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<List<ContentGroup>>> call = service.loadContentList();
        RetrofitUtil.request(call, callBack);
    }

    public static void loadBroadcastList(int start, RetrofitUtil.RequestCallBack<ObjectList<Trend>> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<ObjectList<Trend>>> call = service.loadBroadcastList(start);
        RetrofitUtil.request(call, callBack);
    }

    /**
     * 加载推荐人列表
     *
     * @param callBack
     */
    public static void loadRecommnadDaringList(RetrofitUtil.RequestCallBack<ObjectList<User>> callBack) {
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<ObjectList<User>>> call = service.loadRecommnadDaringList(12295222);
        RetrofitUtil.request(call, callBack);
    }

    public static void loadBlogList(int blog_id, RetrofitUtil.RequestCallBack<BlogDetail> callBack) {
        ApiService service = RetrofitUtil.createService();
        String includeFields = "ags,related_albums,related_albums.covers,root_album,share_links_3,extra_html,top_comments,top_like_users";
        Call<BaseResult<BlogDetail>> call = service.loadBlogList(8,blog_id, includeFields);
        RetrofitUtil.request(call, callBack);
    }


}
