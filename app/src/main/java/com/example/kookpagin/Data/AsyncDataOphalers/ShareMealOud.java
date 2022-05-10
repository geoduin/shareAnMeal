package com.example.kookpagin.Data.AsyncDataOphalers;

import com.example.kookpagin.Domain.ResponseDomain.LoginResponse;
import com.example.kookpagin.Domain.ResponseDomain.mealResponse;
import com.example.kookpagin.Logic.LoginData;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ShareMealOud {

    @GET("/api/meal")
    Call<mealResponse> haalMaaltijdenOudOp();

    @POST("/api/auth/login")
    Call<LoginResponse> login(@Body() LoginData loginData);

    @GET("/api/user/profile")
    Call<LoginResponse> getUserProfile(@Header("Authorization") String token);


}
