package com.fz.ribeile.ui.login;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.fz.ribeile.R;
import com.fz.ribeile.base.BaseActivity;
import com.fz.ribeile.databinding.ActivityLoginBinding;

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
