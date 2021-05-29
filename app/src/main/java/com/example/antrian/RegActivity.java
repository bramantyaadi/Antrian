package com.example.antrian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
    }
    public void onClickLogin(View v){
        Intent Login = new Intent(RegActivity.this , MainActivity.class);
        startActivityForResult(Login , 100);
    }
}