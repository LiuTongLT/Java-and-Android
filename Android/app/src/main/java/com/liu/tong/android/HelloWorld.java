package com.liu.tong.android;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloWorld extends BaseActivity implements View.OnClickListener {
    private static final String TAG = "HelloWorld";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
        Log.d(TAG, "onCreate: excuted");

        TextView helloWorld = (TextView) findViewById(R.id.hello_world);
        helloWorld.setOnClickListener(this);

        Button goGit = (Button) findViewById(R.id.go_tong_git);
        goGit.setOnClickListener(this);

        Button goSecond = (Button) findViewById(R.id.go_sencond_activity);
        goSecond.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnData = data.getStringExtra("data return");
                    Log.d(TAG,returnData);

                }
                break;
                default:
                    break;
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            //Intent(packageContext is the beginning activity, target activity)
            case R.id.hello_world:
                intent = new Intent(this,FirstActivity.class);
                startActivityForResult(intent,1);
                break;
            case R.id.go_tong_git:
                String data = "Hello, Tong's Github!";
                intent = new Intent(this,TongGithub.class);
                intent.putExtra("extra data",data);
                startActivity(intent);
                break;

                //启动活动的最佳写法
            case R.id.go_sencond_activity:
                SecondActivity.actionStart(this,"data1","data2");
                break;
            default: break;
        }
    }
}
