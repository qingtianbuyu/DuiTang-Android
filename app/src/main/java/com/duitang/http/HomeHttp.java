package com.duitang.http;

import com.duitang.base.ApiService;
import com.duitang.base.BaseResult;
import com.duitang.base.ObjectList;
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
}
