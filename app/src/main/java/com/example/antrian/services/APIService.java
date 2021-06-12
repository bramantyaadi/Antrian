package com.example.antrian.services;

import com.example.antrian.models.Item_antrian;
import com.example.antrian.models.Result_next_ticket;
import com.example.antrian.models.Result_rv;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface APIService {

    @GET("/api/antrian")
//    @FormUrlEncoded
    Call<Result_rv> getAll();

    @POST("/api/antrian")
    Call<Result_next_ticket> pushingTicket();

}
