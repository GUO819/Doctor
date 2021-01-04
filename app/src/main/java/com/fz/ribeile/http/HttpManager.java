package com.fz.ribeile.http;

import android.util.AndroidException;

import com.google.gson.Gson;

import io.reactivex.android.schedulers.AndroidSchedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author: Guo
 * @date: 2021/1/4
 * @describe:
 */
public class HttpManager {
    /**
     * 外网测试环境
     */
    private final String url = "http://118.178.180.86:9001/";
//    private String url = "";//生产环境


    private static HttpManager httpManager;
    private final OkHttpClient okHttp;
    private final Retrofit retrofit;

    private HttpManager(){
        okHttp = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static HttpManager getInstance(){
        if(httpManager==null){
            synchronized (HttpManager.class){
                if(httpManager == null){
                    httpManager = new HttpManager();
                }
            }
        }
        return httpManager;
    }

    public HttpUrl getService(){
        return retrofit.create(HttpUrl.class);
    }


}
