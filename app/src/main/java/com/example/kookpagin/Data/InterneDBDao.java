package com.example.kookpagin.Data;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.kookpagin.Domain.Maaltijd;

import java.util.List;

//Ongebruikte klasse
public class InterneDBDao  {
    private static volatile InterneDBDao dao;
    public MutableLiveData<List<Maaltijd>> maaltijdenLijst;

    public InterneDBDao(Application app){
        maaltijdenLijst = new MutableLiveData<>();
    }

    public static InterneDBDao instance(Application app){
        if(dao == null){
            dao = new InterneDBDao(app);
        }
        return dao;
    }

    public MutableLiveData<List<Maaltijd>> getMaaltijdenLijstIntern() {
        return maaltijdenLijst;
    }

}
