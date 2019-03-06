package com.liu.tong.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class TongGithub extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tong_github);

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra data");
        Log.d("TongGithub",data);
    }
}
