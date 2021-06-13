package com.example.antrian;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.antrian.contans.contans;
import com.example.antrian.models.Result_next_ticket;
import com.example.antrian.models.Result_wait_done;
import com.example.antrian.services.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PetugasActivity extends AppCompatActivity {
    TextView txt_wait , txt_done , txt_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petugas);
        txt_done = findViewById(R.id.txt_done_petugas);
        txt_wait = findViewById(R.id.txt_wait_petugas);
        txt_total = findViewById(R.id.txt_total);
        WaitAndDone();
    }

    public void onClickTambahTiket(View v){
//        Toast.makeText(this , "Tambah" , Toast.LENGTH_SHORT).show();
        final ProgressDialog progres = new ProgressDialog(this);
        progres.setMessage("Please wait......");
        progres.show();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(contans.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);

        final Call<Result_next_ticket> result_ticket = apiService.pushingTicket();
        result_ticket.enqueue(new Callback<Result_next_ticket>() {
            @Override
            public void onResponse(Call<Result_next_ticket> call, Response<Result_next_ticket> response) {
                progres.dismiss();
                Result_next_ticket result = response.body();
                Toast.makeText(PetugasActivity.this , result.nomor() , Toast.LENGTH_SHORT).show();
                WaitAndDone();
//                finish();
            }

            @Override
            public void onFailure(Call<Result_next_ticket> call, Throwable t) {

            }
        });
    }

    public void WaitAndDone(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(contans.URL_API)
                .addConverterFactory(GsonConverterFactory.create()).build();

        APIService apiService = retrofit.create(APIService.class);

        final Call<Result_wait_done> result_wait_doneCall = apiService.WaitAndDone();
        result_wait_doneCall.enqueue(new Callback<Result_wait_done>() {
            @Override
            public void onResponse(Call<Result_wait_done> call, Response<Result_wait_done> response) {
                Result_wait_done result_wait_done = response.body();
                txt_done.setText(result_wait_done.getDone());
                txt_wait.setText(result_wait_done.getWait());
                Integer total = Integer.parseInt(result_wait_done.getDone()) + Integer.parseInt(result_wait_done.getWait());
                txt_total.setText(total.toString());

            }

            @Override
            public void onFailure(Call<Result_wait_done> call, Throwable t) {

            }
        });
    }

    public void Logout(View v){
        final ProgressDialog progressDialog = new ProgressDialog(PetugasActivity.this);
        progressDialog.setMessage("Please Message....");
        progressDialog.show();
        Intent login = new Intent(PetugasActivity.this , MainActivity.class);
        startActivity(login);
    }
}