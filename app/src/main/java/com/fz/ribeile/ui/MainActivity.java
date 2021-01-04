package com.fz.ribeile.ui;

import android.widget.Toast;

import com.fz.ribeile.R;
import com.fz.ribeile.base.BaseActivity;
import com.fz.ribeile.bean.LoginBean;
import com.fz.ribeile.databinding.ActivityMainBindingImpl;

import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author: Guo
 * @date: 2021/1/4
 * @describe:
 */
public class MainActivity extends BaseActivity<ActivityMainBindingImpl> {
    @Override
    public int initViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        HashMap<String, String> map = new HashMap<>();
        map.put("phone","17625996236");
        map.put("password","123.123.w");
        Observable<LoginBean> login = getHttpService().login(map);
        login.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginBean value) {
                        Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
