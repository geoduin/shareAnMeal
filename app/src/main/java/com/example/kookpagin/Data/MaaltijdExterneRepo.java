package com.example.kookpagin.Data;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kookpagin.Data.AsyncDataOphalers.ShareAPI;
import com.example.kookpagin.Data.AsyncDataOphalers.ShareMealOud;
import com.example.kookpagin.Domain.Maaltijd;
import com.example.kookpagin.Data.AsyncDataOphalers.externeMaaltijdOphaler;
import com.example.kookpagin.Domain.ResponseDomain.MaaltijdResponse;
import com.example.kookpagin.Domain.ResponseDomain.mealResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Een repository om maaltijden op te halen
public class MaaltijdExterneRepo {
    private static final String urlS = "https://shareameal-api.herokuapp.com";
    private static final String urlMine = "https://share-meal-programmeren-4.herokuapp.com";
    public MutableLiveData<List<Maaltijd>> maaltijdenLijst;
    private static volatile MaaltijdExterneRepo instance;
    private static final String retrieveTag = "Retrieve";
    private static final String error =  "Error";
    private Application application;
    //private externeMaaltijdOphaler async;

    public MaaltijdExterneRepo(Application app){
        application = app;
        //async = new externeMaaltijdOphaler(application);
        this.maaltijdenLijst = new MutableLiveData<>();
        //voerOphaalTaskUit();
        getMeals();
        //haalMaaltijdenOp();
    }

    public static MaaltijdExterneRepo instance(Application app){
        if(instance == null){
            instance = new MaaltijdExterneRepo(app);
        }
        return instance;
    }

    //Controleert of er wifi aanwezig is. True = wel wifi, False = geen wifi
    public boolean checkWifi(){
        ConnectivityManager connect = (ConnectivityManager)application.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiCheck = null;
        Log.i(retrieveTag, "Netwerk is bepaalt");
        if(connect != null) {
            wifiCheck = connect.getActiveNetworkInfo();
            Log.i(retrieveTag, "Netwerk");
        }

        Log.i(retrieveTag, "Geeft boolean terug");
        return wifiCheck != null && wifiCheck.isConnected();
    }

    public MutableLiveData<List<Maaltijd>> getMaaltijdenLijst() {
        return maaltijdenLijst;
    }


//    public void voerOphaalTaskUit(){
//        Log.i(retrieveTag, "Instantieert asyncTask");
//        async = new externeMaaltijdOphaler(application);
//        this.maaltijdenLijst = async.getAsyncMaaltijdenLijst();
//        Log.i(retrieveTag, "Begin asyncTask uitvoering");
//        async.execute();
//    }
    //Robins Share-a-meal API;
    public void getMeals(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlS)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        ShareMealOud oud = retrofit.create(ShareMealOud.class);
        Call<mealResponse> res = oud.haalMaaltijdenOudOp();

        res.enqueue(new Callback<mealResponse>() {
            @Override
            public void onResponse(Call<mealResponse> call, Response<mealResponse> response) {
                if(response.isSuccessful()){
                    maaltijdenLijst.setValue(response.body().getList());
                }
            }

            @Override
            public void onFailure(Call<mealResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    //Xins Share-a-meal API
    public void haalMaaltijdenOp(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlMine)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        ShareAPI shareMeal = retrofit.create(ShareAPI.class);
        Call<MaaltijdResponse> read = shareMeal.haalMaaltijdenOp();

        read.enqueue(new Callback<MaaltijdResponse>() {
            @Override
            public void onResponse(Call<MaaltijdResponse> call, Response<MaaltijdResponse> response) {
                if(response.isSuccessful()){
                    Log.i("Ai", "Aiai");
                    response.body().getMeal();
                }
            }

            @Override
            public void onFailure(Call<MaaltijdResponse> call, Throwable t) {
                Log.e("ERROR", t.getMessage());
            }
        });

        //
    }


}
