package com.example.antrian.services;

import com.example.antrian.models.Item_antrian;
import com.example.antrian.models.Result_rv;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

public interface APIService {

    @GET("/api/antrian")
//    @FormUrlEncoded
    Call<Result_rv> getAll();
}
