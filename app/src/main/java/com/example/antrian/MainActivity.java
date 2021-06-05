package com.example.antrian;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btn_login;
    EditText edt_login_username , edt_login_password;
    ArrayList<UserData> users;
    AppDatabase antriandb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_login = findViewById(R.id.btn_login);
        edt_login_password = findViewById(R.id.edt_login_password);
        edt_login_username = findViewById(R.id.edt_login_username);
        users = new ArrayList<>();
        antriandb = AppDatabase.getDatabase(this);
        new LoginUser().execute();
    }

    public void onClickReg(View v){
        Intent Reg = new Intent(MainActivity.this , RegActivity.class);
        startActivityForResult(Reg , 100);
    }
    public void onClickLogin(View v){
        final ProgressDialog progres = new ProgressDialog(this);
        progres.setMessage("Please Wait.......");
        progres.show();

        String email = edt_login_username.getText().toString();
        String password = edt_login_password.getText().toString();


        Boolean fail = false;
        for (int i = 0 ; i < users.size() ; i++){
            if (users.get(i).email.equalsIgnoreCase(email) && users.get(i).password.equalsIgnoreCase(password)){
                fail = true;
                clear();
                Intent Home = new Intent(MainActivity.this , HomeActivity.class);
                startActivityForResult(Home , 100);
                break;
            }
        }
        if (fail == false){
            progres.hide();
            Toast.makeText(MainActivity.this , "Login Gagal Email / Password Salah" , Toast.LENGTH_SHORT).show();
        }


//        Toast.makeText(this , username , Toast.LENGTH_SHORT).show();
//
    }

    public void clear(){
        edt_login_username.setText("");
        edt_login_password.setText("");
    }

    private class LoginUser extends AsyncTask<Void , Void , List<UserData>> {
        @Override
        protected List<UserData> doInBackground(Void... voids) {
            return antriandb.userDAO().getAllUser();
        }

        @Override
        protected void onPostExecute(List<UserData> data) {
            super.onPostExecute(data);
            users.addAll(data);
        }
    }
}