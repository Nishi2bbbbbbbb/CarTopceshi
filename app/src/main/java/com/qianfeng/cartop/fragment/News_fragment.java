package com.qianfeng.cartop.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2015/11/21.
 * 新闻的fragment
 */
public class News_fragment extends Fragment {
    private static News_fragment news_fragment;
    public static News_fragment getInstance() {

        if (news_fragment == null) {
            news_fragment = new News_fragment();
        }
        return news_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
