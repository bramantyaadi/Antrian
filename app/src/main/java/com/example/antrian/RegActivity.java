package com.example.antrian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {
    AppDatabase antriandb;
    EditText edt_reg_email , edt_reg_password , edt_reg_confirmpassword , edt_reg_nama;
    Button btn_reg;
    Spinner sp_role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);
        edt_reg_email = findViewById(R.id.edt_reg_email);
        edt_reg_password = findViewById(R.id.edt_reg_password);
        edt_reg_confirmpassword = findViewById(R.id.edt_reg_confirmpassword);
        btn_reg = findViewById(R.id.btn_reg);
        sp_role = findViewById(R.id.sp_role);
        antriandb = AppDatabase.getDatabase(this);

        String[] role = new String[]{
                "admin" ,
                "petugas"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this , android.R.layout.simple_spinner_item , role);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_role.setAdapter(adapter);



    }
    public void onClickLogin(View v){
        Intent Login = new Intent(RegActivity.this , MainActivity.class);
        startActivityForResult(Login , 100);
    }
    public void onClickRegister(View v){
        String email = edt_reg_email.getText().toString();
        String password = edt_reg_password.getText().toString();
        String conf_password = edt_reg_confirmpassword.getText().toString();
        String role = sp_role.getSelectedItem().toString();
        UserData userdata = new UserData(email , role , password);


        if (email.isEmpty()){
            Toast.makeText(this , "Email Anda Kosong" , Toast.LENGTH_SHORT).show();
        }
        else {
            if (password.isEmpty()){
                Toast.makeText(this , "Password Anda Kosong" , Toast.LENGTH_SHORT).show();
            }
            else {
                if (password.matches(conf_password)){
                    // Register Disini
                    try {
                        new RegUser().execute(userdata);
                        clear();
                    }
                    catch (Exception e){
                        Toast.makeText(this , "Terjadi Error" , Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(this , "Password Tidak Sama Dengan Confirmasi Paswword" , Toast.LENGTH_SHORT).show();
                    edt_reg_confirmpassword.setText("");
                    edt_reg_password.setText("");
                }
            }
        }
    }
    public void clear(){
        edt_reg_email.setText("");
        edt_reg_password.setText("");
        edt_reg_nama.setText("");
        edt_reg_confirmpassword.setText("");

    }

    private class RegUser extends AsyncTask<UserData , Void , Void>{
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(UserData... userData) {
            antriandb.userDAO().insert(userData[0]);
            return null;
        }
    }
}