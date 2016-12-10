package com.duitang.util;

import android.content.Context;

import com.duitang.R;
import com.duitang.base.ApiService;
import com.duitang.base.BaseConfig;
import com.duitang.base.BaseResult;
import com.duitang.base.DTApplication;
import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Title:
 * description:
 * author: yking
 * created on: 2016/12/4 下午1:51
 */
public class RetrofitUtil {

    private static Retrofit retrofit;

    /**
     * 得到Retrofit的实例
     */
    public synchronized static Retrofit getRetrofit() {
        if (retrofit == null) {
            ClearableCookieJar cookieJar =
                    new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(DTApplication.getInstance()));

            Interceptor interceptor = new Interceptor() {
                @Override
                public okhttp3.Response intercept(Chain chain) throws IOException {
                    Request original = chain.request();
                    HttpUrl originalHttpUrl = original.url();

                    HttpUrl url = originalHttpUrl.newBuilder()
                            .addQueryParameter("platform_name", "iOS")
                            .addQueryParameter("__domain", "www.duitang.com")
                            .addQueryParameter("app_version", "6.5.0 rv:172349")
                            .addQueryParameter("device_platform", "iPhone8%2C1")
                            .addQueryParameter("app_code", "gandalf")
                            .addQueryParameter("locale","zh_CN")
                            .addQueryParameter("platform_version","10.11.1")

                            .build();

                    // Request customization: add request headers
                    Request.Builder requestBuilder = original.newBuilder()
                            .url(url);

                    Request request = requestBuilder.build();
                    return chain.proceed(request);
                }
            };

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient client = new OkHttpClient.Builder()
                    .retryOnConnectionFailure(false)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .writeTimeout(10, TimeUnit.SECONDS)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .cookieJar(cookieJar)
                    .addInterceptor(logging)
                    .addInterceptor(interceptor)
                    .build();

            retrofit = new Retrofit
                    .Builder()
                    .client(client)
                    .baseUrl(BaseConfig.BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public synchronized static ApiService createService() {
        Retrofit retrofit = getRetrofit();
        return retrofit.create(ApiService.class);
    }

    /**
     * 发送异步请求
     *
     * @param call     要发送的请求
     * @param callBack 请求成功结果回调
     */
    public static <T> void request(Call<BaseResult<T>> call, final RequestCallBack<T> callBack) {
        final Context context = DTApplication.getInstance();
        call.enqueue(new Callback<BaseResult<T>>() {
            @Override
            public void onResponse(Call<BaseResult<T>> call, Response<BaseResult<T>> response) {
                BaseResult<T> result = response.body();
                if (result != null) {
                    if (result.status == 1) {
                        if (callBack != null) {
                            callBack.success(result.data);
                        }
                    } else {
                        processError(callBack, context, null);
                    }
                } else {
                    processError(callBack, context, ResourcesUtil.getString(context, R.string.server_error));
                }
            }

            @Override
            public void onFailure(Call<BaseResult<T>> call, Throwable t) {
                t.printStackTrace();
                callBack.failure("");
                if (t instanceof ConnectException) {
                    ToastUtils.showMiddleToast(ResourcesUtil.getString(context, R.string.net_error));
                } else if (t instanceof SocketTimeoutException) {
                    ToastUtils.showMiddleToast(ResourcesUtil.getString(context, R.string.time_out));
                } else if (t instanceof JsonParseException) {
                    ToastUtils.showMiddleToast(ResourcesUtil.getString(context, R.string.data_press_error));
                } else {
                    ToastUtils.showMiddleToast(ResourcesUtil.getString(context, R.string.server_error));
                }
            }
        });
    }


    /**
     * 回调处理
     *
     * @param callBack
     * @param context
     * @param message
     * @param <T>
     */
    private static <T> void processError(RequestCallBack<T> callBack, Context context, String message) {
        if (callBack != null) {
            callBack.failure(message);
        }
    }

    /**
     * 创建一个requestBody
     */
    public static RequestBody createRequestBody(Object object) {
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        if (object == null) {
            return RequestBody.create(mediaType, "");
        }

        if (object instanceof String) {
            return RequestBody.create(mediaType, (String) object);
        }

        String json = new Gson().toJson(object);
        return RequestBody.create(mediaType, json);
    }

    /**
     * 请求成功的回调函数
     *
     * @param <T> 成功返回的数据
     */
    public interface RequestCallBack<T> {
        /**
         * 请求数据成功
         *
         * @param data
         */
        void success(T data);

        void failure(String failure);
    }

}
