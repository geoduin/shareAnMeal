package com.example.kookpagin.Logic;

import com.example.kookpagin.Domain.LoginResponse;
import com.example.kookpagin.Domain.Maaltijd;
import com.example.kookpagin.Domain.mealResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Ophaler {

    @GET("api/meal")
    Call<mealResponse> haalMaaltijdenOp();

    @POST("api/auth/login")
    Call<LoginResponse> login(@Body() LoginData loginData);

    @GET("api/user/profile")
    Call<LoginResponse> getUserProfile(@Header("Authorization") String token);


}
