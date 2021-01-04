package com.fz.ribeile.base;

import android.content.pm.ActivityInfo;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

/**
 * @author: Guo
 * @date: 2021/1/3
 * @describe:
 */
public abstract class BaseActivity<VD extends ViewDataBinding> extends AppCompatActivity {
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
}
