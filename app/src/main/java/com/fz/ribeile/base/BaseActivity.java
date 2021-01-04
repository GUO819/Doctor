package com.fz.ribeile.base;

import android.content.pm.ActivityInfo;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.fz.ribeile.http.HttpManager;
import com.fz.ribeile.http.HttpUrl;

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

    public HttpUrl getHttpService(){
        return HttpManager.getInstance().getService();
    }

    public void setText(TextView tv,String content){
        tv.setText(content);
    }

    public void setVisibility(View v,Boolean flag){
        v.setVisibility(flag?View.GONE:View.VISIBLE);
    }
}
