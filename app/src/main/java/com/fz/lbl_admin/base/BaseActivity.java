package com.fz.lbl_admin.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.fz.lbl_admin.http.HttpManager;
import com.fz.lbl_admin.http.HttpUrl;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import me.jessyan.autosize.internal.CustomAdapt;

/**
 * @author: Guo
 * @date: 2021/1/3
 * @describe:
 */
public abstract class BaseActivity<VD extends ViewDataBinding> extends AppCompatActivity implements CustomAdapt {
    protected VD dataBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.setContentView(this,initViewLayout());
        //保持竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
        initListener();
        initData();
    }

    public abstract int initViewLayout();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();

    protected HttpUrl getHttpService(){
        return HttpManager.getInstance().getService();
    }

    protected <T> void getObservable(Observable<T> observable, final IDataListener a){
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<T>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(T value) {
                a.success(value);
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(BaseActivity.this, "请求错误，请检查", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {

            }
        });
    }
    public interface IDataListener{
        <T> void success(T s);
        void error(String s);
    }

    public void setText(TextView tv,String content){
        tv.setText(content);
    }

    public void setVisibility(View v,Boolean flag){
        v.setVisibility(flag?View.GONE:View.VISIBLE);
    }

    public void jump(Class<?> activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    @Override
    public boolean isBaseOnWidth() {
        return false;
    }

    @Override
    public float getSizeInDp() {
        return 667;
    }
}
