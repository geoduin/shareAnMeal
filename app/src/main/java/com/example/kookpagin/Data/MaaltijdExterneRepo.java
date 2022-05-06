package com.example.kookpagin.Data;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kookpagin.Domain.Maaltijd;
import com.example.kookpagin.Data.AsyncDataOphalers.externeMaaltijdOphaler;

import java.util.List;

//Een repository om maaltijden op te halen
public class MaaltijdExterneRepo {

    public MutableLiveData<List<Maaltijd>> maaltijdenLijst;
    private static MaaltijdExterneRepo instance;
    private static final String retrieveTag = "Retrieve";
    private static final String error =  "Error";
    private Application application;
    private externeMaaltijdOphaler async;

    public MaaltijdExterneRepo(Application app){
        application = app;
        async = new externeMaaltijdOphaler(application);
        this.maaltijdenLijst = async.getAsyncMaaltijdenLijst();
        voerOphaalTaskUit();
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


    public void voerOphaalTaskUit(){
        Log.i(retrieveTag, "Instantieert asyncTask");
        async = new externeMaaltijdOphaler(application);
        this.maaltijdenLijst = async.getAsyncMaaltijdenLijst();
        Log.i(retrieveTag, "Begin asyncTask uitvoering");
        async.execute();
    }

}
