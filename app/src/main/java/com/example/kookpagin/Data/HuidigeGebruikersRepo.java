package com.example.kookpagin.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kookpagin.Domain.Profiel;

public class HuidigeGebruikersRepo {

    private static volatile HuidigeGebruikersRepo mGebruikerRepo;
    private LiveData<Profiel> mProfiel;
    private LiveData<Profiel> mGebruiker;
    public HuidigeGebruikersRepo(Application application){
        this.mGebruiker = new MutableLiveData<>();
        this.mProfiel = new MutableLiveData<>();
    }

    public static HuidigeGebruikersRepo getInstance(Application application){
        if(mGebruikerRepo == null){
            mGebruikerRepo = new HuidigeGebruikersRepo(application);
        }
        return mGebruikerRepo;
    }

    public LiveData<Profiel> haalGebruikers() {
        return mGebruiker;
    }

    public LiveData<Profiel> getProfiel() {
        return mProfiel;
    }

    public void Login(String email, String password){
        //mProfiel setValue
    }

    public void haalProfielOp(String jwt){
        //Profiel retriever
    }
}
