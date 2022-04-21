package com.example.kookpagin.UI.viewModels;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.kookpagin.Data.MaaltijdExterneRepo;
import com.example.kookpagin.Domain.Maaltijd;

import java.util.ArrayList;
import java.util.List;
//Viewmodel voor de maaltijden
//Houdt veranderingen van de livedata in de gaten
//Is verantwoordelijk voor het ophalen van de maaltijden en het filteren daarvan
public class maaltijdenViewModel extends AndroidViewModel {
    private LiveData<List<Maaltijd>> maaltijdenBord;
    private List<Maaltijd>filterMaaltijd;
    private MaaltijdExterneRepo externeRepo;
    private boolean isVegaFilter;
    private boolean isVeganFilter;

    //Constructor
    public maaltijdenViewModel(Application application) {
        super(application);
        externeRepo = MaaltijdExterneRepo.instance(application);
        maaltijdenBord = externeRepo.getMaaltijdenLijst();
    }

    public LiveData<List<Maaltijd>> getMaaltijdenBord() {
        return maaltijdenBord;
    }

    public void haalMaaltijdenOp(){
        boolean isConnected = externeRepo.checkWifi();
        if(isConnected){
            //Voert async task uit om maaltijden op te halen.
            externeRepo.voerOphaalTaskUit();
            maaltijdenBord = externeRepo.getMaaltijdenLijst();
        } else{
            //Anders haalt het een lege lijst op.
            maaltijdenBord = externeRepo.getMaaltijdenLijst();
        }
    }

    //Ontvangt alle maaltijden, ter voorbereiding voor het filteren daarvan
    public void setFilterMaaltijd(List<Maaltijd> filterMaaltijd) {
        this.filterMaaltijd = filterMaaltijd;
    }

    //Filtert de maaltijden, op basis van vega of vegan attributen
    public List<Maaltijd> getFilterMaaltijd() {
        List<Maaltijd> gefilterdeLijst = new ArrayList<>();
        //Als isVega en isVegan false is. Dan is er geen restricties aanwezig en geeft het de hele lijst terug.
        if(!isVegaFilter && !isVeganFilter){
            return filterMaaltijd;
        }
        //Als beide of vega true is, dan geeft het alleen de maaltijden die aan de voorwaarden voldoen
        for (Maaltijd meal: filterMaaltijd) {
            if(meal.isVega() == isVegaFilter && meal.isVegan() == isVeganFilter){
                gefilterdeLijst.add(meal);
            } else if(meal.isVega() == isVegaFilter && meal.isVegan()){
                gefilterdeLijst.add(meal);
            }
        }
        return gefilterdeLijst;
    }

    //Ontvangt de sharedpreference attributen
    public void setVegaFilter(boolean vegaFilter) {
        isVegaFilter = vegaFilter;
    }
    //Ontvangt de sharedpreference attributen
    public void setVeganFilter(boolean veganFilter) {
        isVeganFilter = veganFilter;
    }
}
