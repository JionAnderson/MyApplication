package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;


import java.text.SimpleDateFormat;

/**
 * 欢迎页
 */
public class OpenActivity extends BaseActivity {
    MySqliteOpenHelper helper = null;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new MySqliteOpenHelper(this);
        setContentView(R.layout.activity_open);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Boolean isFirst= (Boolean) SPUtils.get(OpenActivity.this, SPUtils.IF_FIRST,true);
                //两秒后跳转到主页面
                Intent intent = new Intent();
                intent.setClass(OpenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
