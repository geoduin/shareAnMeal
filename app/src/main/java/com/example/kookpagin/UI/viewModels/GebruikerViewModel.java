package com.example.kookpagin.UI.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kookpagin.Data.HuidigeGebruikersRepo;
import com.example.kookpagin.Domain.Profiel;

public class GebruikerViewModel extends AndroidViewModel {
    private HuidigeGebruikersRepo mGebruikerRepo;
    private LiveData<Profiel> mProfiel;
    private LiveData<Profiel> mGebruiker;

    public GebruikerViewModel(Application application) {
        super(application);
        this.mGebruikerRepo = HuidigeGebruikersRepo.getInstance(application);
        this.mGebruiker = mGebruikerRepo.haalGebruikers();
        this.mProfiel = mGebruikerRepo.getProfiel();
    }

    public LiveData<Profiel> getProfiel() {
        return mProfiel;
    }

    public LiveData<Profiel> getGebruiker() {
        return mGebruiker;
    }

    public void applyLogin(String email, String password){
        mGebruikerRepo.Login(email, password);
    }

    public void getProfile(String jwt){

    }

}
