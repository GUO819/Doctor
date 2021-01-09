package com.fz.lbl_admin.http;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
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
    private final String url = "http://118.178.180.86:9001";
//    private String url = "";//生产环境


    private static HttpManager httpManager;
    private final OkHttpClient okHttp;
    private final Retrofit retrofit;

    private HttpManager(){
        okHttp = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder();
                        builder.addHeader("Content-Type","application/json");
                        builder.addHeader("Accept","application/json");
                        Request build = builder.build();
                        return chain.proceed(build);
                    }

                })
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .client(okHttp)
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
