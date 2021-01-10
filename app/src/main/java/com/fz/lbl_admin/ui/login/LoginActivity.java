package com.fz.lbl_admin.ui.login;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.fz.lbl_admin.R;
import com.fz.lbl_admin.base.BaseActivity;
import com.fz.lbl_admin.bean.LoginBean;
import com.fz.lbl_admin.databinding.ActivityLoginBinding;
import com.fz.lbl_admin.util.IPath;
import com.fz.lbl_admin.util.SpUtil;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author: Guo
 * @date: 2021/1/4
 * @describe:
 */
public class LoginActivity extends BaseActivity<ActivityLoginBinding> {

    private Animation animation_up,animation_down;

    @Override
    public int initViewLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {
        //开启背景动画
        startBgAnimation();
    }

    @Override
    public void initListener() {
        dataBinding.btnLogin.setEnabled(true);
        dataBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("phone","18749178175");
                jsonObject.addProperty("password","123.123.w");
                RequestBody requestBody = RequestBody.create(jsonObject.toString(), MediaType.parse("application/json;charset=utf-8"));
                getObservable(getHttpService().login(requestBody), new IDataListener() {
                    @Override
                    public <T> void success(T s) {
                        LoginBean bean = (LoginBean) s;
                        if(bean.code==200){
                            Gson gson = new Gson();
                            SpUtil.put(IPath.userData,gson.toJson(bean.result));

                        }
                        Toast.makeText(LoginActivity.this,bean.message, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void error(String s) {
                        Toast.makeText(LoginActivity.this,"网络请求失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void initData() {


    }

    private void startBgAnimation(){
        animation_up = AnimationUtils.loadAnimation(this, R.anim.login_animation_up);
        animation_down = AnimationUtils.loadAnimation(this, R.anim.login_animation_down);
        dataBinding.ivBg.startAnimation(animation_up);
        animation_up.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dataBinding.ivBg.startAnimation(animation_down);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animation_down.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dataBinding.ivBg.startAnimation(animation_up);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        dataBinding.ivBg.clearAnimation();
        super.onDestroy();
    }
}
