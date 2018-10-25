package com.hm.iou.template.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hm.iou.base.BaseBizAppLike;
import com.hm.iou.router.Router;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Router.init(this);

        BaseBizAppLike appLike = new BaseBizAppLike();
        appLike.onCreate(this);
        appLike.initServer("http://192.168.1.217", "http://192.168.1.217",
                "http://192.168.1.217");

        findViewById(R.id.btn_test1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.getInstance().buildWithUrl("hmiou://m.54jietiao.com/template/paper_borrow")
                        .withString("show_include", "true")
                        .navigation(MainActivity.this);
            }
        });

        findViewById(R.id.btn_test2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.getInstance().buildWithUrl("hmiou://m.54jietiao.com/template/paper_receive")
                        .withString("show_include", "true")
                        .navigation(MainActivity.this);

            }
        });

        findViewById(R.id.btn_test3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Router.getInstance().buildWithUrl("hmiou://m.54jietiao.com/template/select_type")
                        .navigation(MainActivity.this);
            }
        });

    }
}
