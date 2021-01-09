package com.fz.lbl_admin;

import android.app.Application;
import android.content.Context;

/**
 * @author: Guo
 * @date: 2021/1/6
 * @describe:
 */
public class App extends Application{
    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }
}
