package com.fz.ribeile;

import com.fz.ribeile.base.BaseActivity;
import com.fz.ribeile.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity<ActivityMainBinding> {

    @Override
    public int initViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        dataBinding.tv.setText("郭金沂");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }
}