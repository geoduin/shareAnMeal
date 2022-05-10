package com.example.kookpagin.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.kookpagin.Domain.Profiel;
import com.example.kookpagin.Domain.ResponseDomain.ParticipationResponse;

public class DeelnameRepo {
    private static volatile DeelnameRepo mRepo;
    private LiveData<ParticipationResponse> mResponse;


    public DeelnameRepo(Application app){
        this.mResponse = new MutableLiveData<>();
    }

    public LiveData<ParticipationResponse> getResponse() {
        return mResponse;
    }

    public static DeelnameRepo instanceOf(Application app){
        if(mRepo == null){
            mRepo = new DeelnameRepo(app);
        }
        return mRepo;
    }

    public void participateInMeal(int mealId, int userId , Profiel gebruiker){

    }

}
