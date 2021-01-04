package com.fz.ribeile.http;

import com.fz.ribeile.bean.LoginBean;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * @author: Guo
 * @date: 2021/1/4
 * @describe:
 */
public interface HttpUrl {
    @Multipart
    @POST("/sys/phoneLogin")
    Observable<LoginBean> login(@PartMap HashMap<String,String> map);
}
