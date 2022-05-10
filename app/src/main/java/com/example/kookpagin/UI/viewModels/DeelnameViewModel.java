package com.example.kookpagin.UI.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kookpagin.Data.DeelnameRepo;
import com.example.kookpagin.Domain.Profiel;
import com.example.kookpagin.Domain.ResponseDomain.ParticipationResponse;

public class DeelnameViewModel extends AndroidViewModel {
    private DeelnameRepo mRepo;
    private LiveData<ParticipationResponse> mResponse;

    public DeelnameViewModel(@NonNull Application application) {
        super(application);
        this.mRepo = DeelnameRepo.instanceOf(application);
        this.mResponse= mRepo.getResponse();
    }

    public void participateInMeal(int meal, int userId, Profiel user){
        mRepo.participateInMeal(meal, userId, user);
    }
}
