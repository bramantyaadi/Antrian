package com.example.antrian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickReg(View v){
        Intent Reg = new Intent(MainActivity.this , RegActivity.class);
        startActivityForResult(Reg , 100);
    }
    public void onClickLogin(View v){
        Intent Home = new Intent(MainActivity.this , HomeActivity.class);
        startActivityForResult(Home , 100);
    }
}