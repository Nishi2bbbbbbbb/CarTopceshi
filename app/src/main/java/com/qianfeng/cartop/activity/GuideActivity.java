package com.qianfeng.cartop.activity;
import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.app.Activity;
import android.content.Intent;

import com.qianfeng.cartop.R;
import com.qianfeng.cartop.adapter.GuidePagerAdapter;

public class GuideActivity extends Activity {

    private ViewPager viewPager;
    private int[] images = { R.drawable.navigation_page_1, R.drawable.navigation_page_2,R.drawable.navigation_page_3 };//图片资源
    private List<View> list;
    private Button button_go;//进入主界面的按钮(立即体验)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        viewPager = (ViewPager) findViewById(R.id.viewPager_guide);
        button_go=(Button) findViewById(R.id.button_go);
        list = new ArrayList<View>();
        for (int i = 0; i < images.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ScaleType.FIT_XY);
            imageView.setImageResource(images[i]);
            list.add(imageView);
        }
        viewPager.setAdapter(new GuidePagerAdapter(list, this));

		/*
		 * 表示当前测viewpager中的page的状态发生改变时回调的接口
		 */
        viewPager.setOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            /*
                         * 表示当一个新的page界面被选中时回调的方法 参数表示 当前选择的page在viewpager中的下标
                         */
            @Override
            public void onPageSelected(int position) {

                if (position == 2) {
                    button_go.setVisibility(View.VISIBLE);
                    button_go.setOnClickListener(new OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(GuideActivity.this, HomeActivity.class);
                            startActivity(intent);
                            GuideActivity.this.finish();//当前页面关闭

                        }
                    });
                }
            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


}
