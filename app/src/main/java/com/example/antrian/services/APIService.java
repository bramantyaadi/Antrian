package com.example.antrian.services;

import com.example.antrian.models.Item_antrian;
import com.example.antrian.models.Result_last_call;
import com.example.antrian.models.Result_next_antrian;
import com.example.antrian.models.Result_next_ticket;
import com.example.antrian.models.Result_rv;
import com.example.antrian.models.Result_wait_done;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface APIService {

    @GET("/api/antrian")
//    @FormUrlEncoded
    Call<Result_rv> getAll();

    @POST("/api/antrian")
    Call<Result_next_ticket> pushingTicket();

    @PUT("/api/antrian")
    Call<Result_next_antrian> NextAntrian();

    @GET("/api/lastcall/antrian")
    Call<Result_last_call> lastCall();

    @GET("/api/antrian/wait/done")
    Call<Result_wait_done> WaitAndDone();

}
