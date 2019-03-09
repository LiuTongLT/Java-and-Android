package com.liu.tong.android;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

//启动活动的最佳写法
    public static void actionStart(Context context, String data1, String data2){
        Intent intent = new Intent(context,SecondActivity.class);
        intent.putExtra("para1",data1);
        intent.putExtra("para2", data2);
        context.startActivity(intent);
    }
}
