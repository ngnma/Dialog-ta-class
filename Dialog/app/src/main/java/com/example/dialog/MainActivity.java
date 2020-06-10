package com.example.dialog;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.*;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        findViewById(R.id.progressButton);
        setContentView(R.layout.activity_main);

    }//@RequiresApi(api = Build.VERSION_CODES.P)
    public void showProgressDialog(View view){
        final ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("Progress Dialog");
        progressDialog.setMessage("please wait ...");
//        progressDialog.setCancelable(false);//always waiting
        long progress=1000L;//time waiting
        long secondProgress=500L;
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                progressDialog.dismiss();
//            }
//
//        },progress);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //if(progressDialog.getProgress()<progressDialog.getMax())
                    progressDialog.incrementProgressBy(12);//har bar chand % por she
                //else{progressDialog.dismiss();}
            }
        },0,progress);
        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(progressDialog.getProgress()<progressDialog.getMax()){
                    progressDialog.incrementSecondaryProgressBy(20);//on khati ke mige cheghadesh download shode!
                }
            }
        },0,secondProgress);
        progressDialog.show();
    }


    public void showAlertDialog(View view){
        AlertDialog.Builder alertDialog =new AlertDialog.Builder(this);
        //type1
//        alertDialog.setTitle("Alert dia")
//                .setMessage("do you want delete?")
//                .setIcon(android.R.drawable.ic_popup_reminder)
//                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"done",Toast.LENGTH_LONG).show();
//                    }
//                })
//                .setNegativeButton("No",null)
//                .setNeutralButton("cancel",null)//hich kar nemikone.samte chap miad
//                .show();
        //type2
//        alertDialog.setCancelable(false)
//                .setTitle("Question")
//                .setSingleChoiceItems(new String[]{"A", "B", "C"}, -1, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this,"which: "+which,Toast.LENGTH_SHORT).show();
//                    }
//                })//checkeditem on itemie ke aval entekhab shode. -1 bedone difulte
//                .setPositiveButton("ok",null)
//                .show();
    }
}

