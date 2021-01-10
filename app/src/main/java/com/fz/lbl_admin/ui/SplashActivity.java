package com.fz.lbl_admin.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.fz.lbl_admin.R;
import com.fz.lbl_admin.base.BaseActivity;
import com.fz.lbl_admin.bean.LoginBean;
import com.fz.lbl_admin.databinding.ActivitySplashBinding;
import com.fz.lbl_admin.ui.login.LoginActivity;
import com.fz.lbl_admin.util.IPath;
import com.fz.lbl_admin.util.SpUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class SplashActivity extends BaseActivity<ActivitySplashBinding> {

    @Override
    public int initViewLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        //全屏展示
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent();
                String data = SpUtil.getString(IPath.userData, "");
                if(data.equals("")){
                    intent.setClass(SplashActivity.this, LoginActivity.class);
                }else {
                    LoginBean.ResultBean bean = new Gson().fromJson(data, new TypeToken<LoginBean.ResultBean>(){}.getType());
                    if (bean.token.equals("")) {
                        intent.setClass(SplashActivity.this, LoginActivity.class);
                    }else {
                        intent.setClass(SplashActivity.this, MainActivity.class);
                    }
                }
                startActivity(intent);
                finish();
            }
        }, 1000 * 1);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}