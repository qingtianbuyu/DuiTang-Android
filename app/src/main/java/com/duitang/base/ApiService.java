package com.duitang.base;

import com.duitang.entity.Topic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午1:33
 */
public interface ApiService {

    @GET("ad/banner/list/?platform_name=iOS&query_type=normal&__domain=www.duitang.com&app_version=6.5.0%20rv%3A172349&device_platform=iPhone8%2C1&locale=zh_CN&app_code=gandalf&platform_version=10.1.1&screen_height=667&device_name=Unknown%20iPhone&limit=0&ad_id=IGA009&screen_width=375")
    Call<BaseResult<ObjectList<Topic>>> loadTopics(@Query("start") int start);
}
