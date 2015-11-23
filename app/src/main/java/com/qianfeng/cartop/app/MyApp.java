package com.qianfeng.cartop.app;

import android.app.Application;

import com.qianfeng.cartop.utils.ShareUtil;
import com.qianfeng.cartop.utils.VolleyUtil;

/**
 * Created by Administrator on 2015/11/21.
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        VolleyUtil.initVolley(this);
        ShareUtil.init(this);
    }
}
