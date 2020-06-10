package com.example.dialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.*;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.progressButton);
        setContentView(R.layout.activity_main);

    }
    @RequiresApi(api = Build.VERSION_CODES.P)
    public void showProgressDialog(View view){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Progress Dialog");
        progressDialog.setMessage("please wait ...");
        //progressDialog.setCancelable(false);//always waiting
        long progress=3000L;//time waiting
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }

        },progress);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getProgress()<progressDialog.getMax()){
                    progressDialog.incrementProgressBy(2);
                }
            }
        },0,progress);
        progressDialog.show();
    }
}

