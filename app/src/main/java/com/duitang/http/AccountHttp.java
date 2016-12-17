package com.duitang.http;

import com.duitang.base.ApiService;
import com.duitang.base.AppConst;
import com.duitang.base.BaseResult;
import com.duitang.entity.Album;
import com.duitang.entity.LoginResultEntity;
import com.duitang.util.RetrofitUtil;

import retrofit2.Call;

public class AccountHttp {

    public static void loginByAuthInfo(RetrofitUtil.RequestCallBack<LoginResultEntity> callBack) {
        String access_token = "9vnsxUhKoF9VWgMCzmSwxKzo6PNGGk4L0bT0CaqBYOQrbq3RJnOXNixr8qPGhM0iokIfbOmlylOCIejl9Zsn3pArSSYINwEhVYXZ6BmcAwc";
        int expires_in = 7200;
        String refresh_token = "KNl5EPsyFDDBNX4eAjyk8Xh7TZmHzrKYJ2pgoRWJ1IPHYqdOeLVZGIu2J_UjpDnY6SkdJEIwVlE21BAuEuFvdjUHLBQmDuUCVMWubUS61oE";
        String uid = "ohtiiuBxWF5-B7u1q3BO04x-M7yo";
        String site = "weixin";
        ApiService service = RetrofitUtil.createService();
        Call<BaseResult<LoginResultEntity>> call = service.loginByAuthInfo(access_token, expires_in, refresh_token, uid, site);
        RetrofitUtil.request(call, callBack);
    }
}
