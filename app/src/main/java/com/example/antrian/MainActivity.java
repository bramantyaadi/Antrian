package com.example.antrian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText edt_login_username , edt_login_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btn_login);
        edt_login_password = findViewById(R.id.edt_login_password);
        edt_login_username = findViewById(R.id.edt_login_username);

    }

    public void onClickReg(View v){
        Intent Reg = new Intent(MainActivity.this , RegActivity.class);
        startActivityForResult(Reg , 100);
    }
    public void onClickLogin(View v){
        String username = edt_login_username.getText().toString();
        String password = edt_login_password.getText().toString();
        Toast.makeText(this , username , Toast.LENGTH_SHORT).show();
        Intent Home = new Intent(MainActivity.this , HomeActivity.class);
        startActivityForResult(Home , 100);
    }
}