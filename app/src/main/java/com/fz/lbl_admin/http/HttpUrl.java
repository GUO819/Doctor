package com.fz.lbl_admin.http;

import com.fz.lbl_admin.bean.LoginBean;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author: Guo
 * @date: 2021/1/4
 * @describe:
 */
public interface HttpUrl {

    @POST("/sys/mLogin")
    Observable<LoginBean> login(@Body RequestBody requestBody);
}
