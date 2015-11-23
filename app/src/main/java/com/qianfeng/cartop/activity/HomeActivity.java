package com.qianfeng.cartop.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.qianfeng.cartop.R;
import com.qianfeng.cartop.fragment.News_fragment;

///*创建主要的fragment*/
//ssssssssssssss
public class HomeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    private RadioGroup radioGroup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fragmentManager(News_fragment.getInstance());
        String  s = "";

    }

    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.rg_tab);
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkid) {
        switch (checkid){
            case R.id.rb_home:
                fragmentManager(News_fragment.getInstance());
                break;
            case R.id.rb_discover:
                break;
            case R.id.rb_msg:
                break;
            case R.id.rb_mine:
                break;
        }
    }
    private  void  fragmentManager(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment,fragment).commit();
    }
}
