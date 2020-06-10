package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.*;
import android.view.*;


import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    EditText chapkon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn1);
        btn.setOnClickListener(this);
        chapkon=findViewById(R.id.editText);
    }
    @Override
    public void onClick(View v){
        String payam=chapkon.getText().toString();
        switch(v.getId()){
            case R.id.btn1:System.out.println(payam);
            Toast.makeText(getApplicationContext(),payam,Toast.LENGTH_LONG).show();
                Log.i("class ta","chap kon error");
                break;
        }
    }
}
