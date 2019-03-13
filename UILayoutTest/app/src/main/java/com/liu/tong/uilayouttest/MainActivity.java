package com.liu.tong.uilayouttest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.main_button_1);
        button2 = (Button) findViewById(R.id.main_button_2);
        button3 = (Button) findViewById(R.id.main_button_3);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.main_button_1:
                intent = new Intent(MainActivity.this, RelativeLayout.class);
                startActivity(intent);
                break;
            case R.id.main_button_2:
                intent = new Intent(MainActivity.this,FrameLayout.class);
                startActivity(intent);
                break;
            case R.id.main_button_3:
                intent = new Intent(MainActivity.this,PercentFrameLayout.class);
                startActivity(intent);
                break;
                default:
                    break;

        }
    }
}
