package com.fz.lbl_admin.ui;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.Fragment;

import com.fz.lbl_admin.R;
import com.fz.lbl_admin.base.BaseActivity;
import com.fz.lbl_admin.databinding.ActivityMainBinding;

/**
 * @author: Guo
 * @date: 2021/1/4
 * @describe:
 */
public class MainActivity extends BaseActivity<ActivityMainBinding> {



    @Override
    public int initViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        RadioButton childAt = (RadioButton) dataBinding.rdG.getChildAt(0);
        childAt.setChecked(true);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout,new CircleFragment()).commit();
    }

    @Override
    public void initListener() {
        dataBinding.rdG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Fragment fragment = null;
                switch (checkedId){
                    case R.id.rb_1:
                        fragment = Fragment.instantiate(MainActivity.this,CircleFragment.class.getName());
                        break;
                    case R.id.rb_2:
                        fragment = Fragment.instantiate(MainActivity.this,WorkFragment.class.getName());
                        break;
                    case R.id.rb_3:
                        fragment = Fragment.instantiate(MainActivity.this,MessageFragment.class.getName());
                        break;
                    case R.id.rb_4:
                        fragment = Fragment.instantiate(MainActivity.this,MineFragment.class.getName());
                        break;
                    default:
                        break;
                }
                if (fragment != null) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout,fragment).commit();
                }
            }
        });

    }

    @Override
    public void initData() {

    }
}
