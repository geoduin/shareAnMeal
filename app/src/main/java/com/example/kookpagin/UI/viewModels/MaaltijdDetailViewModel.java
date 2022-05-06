package com.example.kookpagin.UI.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.kookpagin.Data.MaaltijdDetailRepo;
import com.example.kookpagin.Domain.MaaltijdDetail;

public class MaaltijdDetailViewModel extends AndroidViewModel {

    private MaaltijdDetailRepo repo;
    private MutableLiveData<MaaltijdDetail> mDetail;

    public MaaltijdDetailViewModel(@NonNull Application application) {
        super(application);
        repo = MaaltijdDetailRepo.instance(application);
        mDetail = repo.getDetailMaaltijd();
    }

    public MaaltijdDetailRepo getRepo() {
        return repo;
    }

    public MutableLiveData<MaaltijdDetail> getDetailMaaltijd() {
        return mDetail;
    }

    public void retrieveMeal(int mealId){
        repo.selectMeal(mealId);
    }
}
