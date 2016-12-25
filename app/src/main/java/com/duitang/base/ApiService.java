package com.duitang.base;

import com.duitang.entity.Album;
import com.duitang.entity.AlbumData;
import com.duitang.entity.BlogDetail;
import com.duitang.entity.ColumnData;
import com.duitang.entity.ContentGroup;
import com.duitang.entity.Favorite;
import com.duitang.entity.LoginResultEntity;
import com.duitang.entity.Topic;
import com.duitang.entity.TopicData;
import com.duitang.entity.Trend;
import com.duitang.entity.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午1:33
 */
public interface ApiService {

    @GET("ad/banner/list/?query_type=normal&limit=0&ad_id=IGA009")
    Call<BaseResult<ObjectList<Topic>>> loadTopics(@Query("start") int start);

    @GET("album/detail/")
    Call<BaseResult<Album>> listAlbumDetail(@Query("album_id") String albumId, @Query("include_fields") String include_fields);

    @GET("blog/list/by_album/")
    Call<BaseResult<ObjectList<AlbumData>>> listAlbumList(@Query("album_id") String albumId, @Query("user_id") int userId, @Query("start") int start);

    @GET("article/detail/")
    Call<BaseResult<AlbumData>> loadArticle(@Query("article_id") String articleId);

    @GET("index/groups/")
    Call<BaseResult<List<ContentGroup>>> loadContentList();

    @GET("people/list/by_interest/")
    Call<BaseResult<ObjectList<User>>> loadRecommnadDaringList(@Query("user_id") int userId);

    @GET("broadcast/list/v2/")
    Call<BaseResult<ObjectList<Trend>>> loadBroadcastList(@Query("start") int start);

    @FormUrlEncoded
    @POST("login/by_auth_info/")
    Call<BaseResult<LoginResultEntity>> loginByAuthInfo(@Field("access_token") String access_token, @Field("expires_in") int expires_in, @Field("refresh_token") String refresh_token, @Field("uid") String uid, @Field("site") String site);

    @GET("blog/detail/")
    Call<BaseResult<BlogDetail>> loadBlogList(@Query("top_like_users_count") int top_like_users_count, @Query("blog_id") int blog_id, @Query("include_fields") String includeFields);

    @GET("people/profile/")
    Call<BaseResult<User>> loadUserProfile(@Query("user_id") int id, @Query("include_fields") String include_fields);

    @GET("moment/list/by_user/")
    Call<BaseResult<ObjectList<Trend>>> momentListByUser(@Query("user_id") int id, @Query("start") int start);

    @GET("album/list/by_user/")
    Call<BaseResult<ObjectList<Album>>> albumListByUser(@Query("user_id") int id, @Query("start") int start);

    @GET("favorite/list/")
    Call<BaseResult<ObjectList<Favorite>>> favoriteList(@Query("user_id") int id, @Query("start") int start);

    @GET("topic/list/by_tags/")
    Call<BaseResult<ObjectList<TopicData>>> topicListByTags(@Query("start") int start, @Query("tags") String tags, @Query("limit") int limit);

    @GET("column/detail/by_heap_name/")
    Call<BaseResult<ObjectList<ColumnData>>> columnDetailByHeapName(@Query("start") int start, @Query("heap_name")String heapName, @Query("limit")int limit);
}
