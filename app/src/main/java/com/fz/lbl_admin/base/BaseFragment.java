package com.fz.lbl_admin.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

/**
 * @author: Guo
 * @date: 2021/1/10
 * @describe:
 */
public abstract class BaseFragment<DB extends ViewDataBinding> extends Fragment {
    public DB dBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(initViewLayout(), container, false);
        dBinding = DataBindingUtil.bind(inflate);
        return inflate;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initListener();
        initData();
    }

    public abstract int initViewLayout();
    public abstract void initView();
    public abstract void initListener();
    public abstract void initData();
}
