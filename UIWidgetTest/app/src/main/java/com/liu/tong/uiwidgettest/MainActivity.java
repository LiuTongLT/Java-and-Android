package com.liu.tong.uiwidgettest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView helloWorld;
    Button button;
    EditText editText;
    ProgressBar progressBar;

    Button button2;
    ProgressBar progressBar2;

    Button button3;

    Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloWorld = (TextView) findViewById(R.id.hello_world);
        button = (Button) findViewById(R.id.main_button);
        editText = (EditText) findViewById(R.id.main_edit_text);
        progressBar = (ProgressBar) findViewById(R.id.process_bar);

        button2 = (Button) findViewById(R.id.main_button2);
        progressBar2 = (ProgressBar) findViewById(R.id.process_bar2);

        button3 = (Button) findViewById(R.id.main_button3);

        button4 = (Button) findViewById(R.id.main_button4);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_button:
                if(progressBar.getVisibility()==View.GONE){
                    progressBar.setVisibility(View.VISIBLE);
                }else{
                    progressBar.setVisibility(View.GONE);
                }
                break;
            case R.id.main_button2:
                int process = progressBar2.getProgress();
                process += 10;
                progressBar2.setProgress(process);
                break;
            case R.id.main_button3:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("This is a dialog!");
                dialog.setMessage("There should have something important!");
                dialog.setCancelable(false);
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Success!",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Canceled",Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
                break;
            case R.id.main_button4:
                ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("This is a progress dialog!");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
                default:
                    break;
        }

    }
}
