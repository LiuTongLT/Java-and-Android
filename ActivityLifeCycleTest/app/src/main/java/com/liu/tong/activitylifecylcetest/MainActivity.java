package com.liu.tong.activitylifecylcetest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreat");

        //In case of when this activity is onDestroy, some data in this activity are lost
        if(savedInstanceState!=null){
            String myData = savedInstanceState.getString("Data save");
            Log.d(TAG,myData);
        }

        Button normal = (Button) findViewById(R.id.start_normal_activity);
        normal.setOnClickListener(this);

        Button dialog = (Button) findViewById(R.id.start_dialog_activity);
        dialog.setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String data = "The data I want to save after this activity is onDestroy!";
        outState.putString("Data save", data);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.start_normal_activity:
                intent = new Intent(this,NormalActivity.class);
                startActivity(intent);
                break;
                case R.id.start_dialog_activity:
                  intent = new Intent(this,DialogActivity.class);
                  startActivity(intent);
                  break;
                  default:
                      break;
        }
    }
}
