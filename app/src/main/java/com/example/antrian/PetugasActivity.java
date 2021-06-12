package com.example.antrian;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.antrian.contans.contans;
import com.example.antrian.models.Result_next_ticket;
import com.example.antrian.services.APIService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PetugasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petugas);
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
//                finish();
            }

            @Override
            public void onFailure(Call<Result_next_ticket> call, Throwable t) {

            }
        });
    }
}