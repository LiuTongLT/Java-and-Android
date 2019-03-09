package com.liu.tong.uiwidgettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView helloWorld;
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorld = (TextView) findViewById(R.id.hello_world);
        button = (Button) findViewById(R.id.main_button);
        editText = (EditText) findViewById(R.id.main_edit_text);


    }

    @Override
    public void onClick(View view) {

    }
}
