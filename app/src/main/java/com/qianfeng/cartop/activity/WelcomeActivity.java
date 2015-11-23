package com.qianfeng.cartop.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;

import com.qianfeng.cartop.R;

/*
* 开机欢迎页面
* */
public class WelcomeActivity extends Activity {
	private SharedPreferences sharedPreferences;
	private Boolean isFirstIn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		sharedPreferences=getSharedPreferences("firstIn_spf", MODE_PRIVATE);

		isFirstIn=sharedPreferences.getBoolean("isFirstIn", true);
		new Handler().postDelayed(new Runnable() {
			
			@Override
			public void run() {

				if (isFirstIn) {
					Intent intent=new Intent(WelcomeActivity.this, GuideActivity.class);
					startActivity(intent);

					Editor editor=sharedPreferences.edit();
					editor.putBoolean("isFirstIn", false);
					editor.commit();
				}else {
					Intent intent=new Intent(WelcomeActivity.this, HomeActivity.class);
					startActivity(intent);
				}
				WelcomeActivity.this.finish();
				finish();
			}
		}, 3000);
	}
}


