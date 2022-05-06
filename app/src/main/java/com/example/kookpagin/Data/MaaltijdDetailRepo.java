package com.example.kookpagin.Data;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.kookpagin.Data.AsyncDataOphalers.ShareAPI;
import com.example.kookpagin.Domain.MaaltijdDetail;
import com.example.kookpagin.Domain.ResponseDomain.MaaltijdDetailResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MaaltijdDetailRepo {
    private static final String baseUrl = "https://share-meal-programmeren-4.herokuapp.com/";
    private MutableLiveData<MaaltijdDetail> mDetailMaaltijd;
    private Application mApplication;
    private static MaaltijdDetailRepo instance;

    public MaaltijdDetailRepo(Application app){
        this.mDetailMaaltijd = new MutableLiveData<>();
        this.mApplication = app;
    }

    public static MaaltijdDetailRepo instance(Application app){
        if(instance != null){
            instance = new MaaltijdDetailRepo(app);
        }
        return instance;
    }

    public Application getApplication() {
        return mApplication;
    }

    public MutableLiveData<MaaltijdDetail> getDetailMaaltijd() {
        return mDetailMaaltijd;
    }

    //Gets based on the selected meal sets a meal with details.
    public void selectMeal(int mealId){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retro = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ShareAPI shareAPI = retro.create(ShareAPI.class);
        //Request body
        //Object o = new Object(Attribute)
        Call<MaaltijdDetailResponse> request = shareAPI.haalDetailMaaltijd(mealId);
        request.enqueue(new Callback<MaaltijdDetailResponse>() {
            @Override
            public void onResponse(Call<MaaltijdDetailResponse> call, Response<MaaltijdDetailResponse> response) {


                //mDetailMaaltijd.setValue();
            }

            @Override
            public void onFailure(Call<MaaltijdDetailResponse> call, Throwable t) {

            }
        });
        //Response

        //call enqueque en response{ set value }
        //mDetailMaaltijd.setValue();
    }
}
