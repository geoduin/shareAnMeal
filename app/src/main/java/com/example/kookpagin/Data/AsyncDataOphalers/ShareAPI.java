package com.example.kookpagin.Data.AsyncDataOphalers;

import com.example.kookpagin.Domain.RequestBodies.detailBody;
import com.example.kookpagin.Domain.ResponseDomain.MaaltijdDetailResponse;
import com.example.kookpagin.Domain.ResponseDomain.MaaltijdResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ShareAPI {

    @GET("api/meal")
    Call<MaaltijdResponse> haalMaaltijdenOp();

    @GET("api/meal/{id}")
    Call<MaaltijdDetailResponse> haalDetailMaaltijd(@Path("id") int mealId);
}
