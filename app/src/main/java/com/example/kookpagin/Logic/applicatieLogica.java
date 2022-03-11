package com.example.kookpagin.Logic;

import android.net.NetworkInfo;

import com.example.kookpagin.Data.DaoInterface;
import com.example.kookpagin.Data.Repository;
import com.example.kookpagin.Domain.DomainFactory;
import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.Ingrediënt;
import com.example.kookpagin.Domain.Maaltijd;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class applicatieLogica {
    private DaoInterface dataOpslag;
    private DomainFactory factory;
    private Repository repository;

    public applicatieLogica(DaoInterface soort, DomainFactory factory) {
        this.dataOpslag = soort;
        this.factory = factory;
        this.repository = new Repository(soort);
    }

    public List<Maaltijd> haalMaaltijdenOpUit(NetworkInfo wifiCheck){
        List<Maaltijd>list = null;
        try {
            list = repository.retrieveData(wifiCheck);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String geefAllergenenTerug(List<Ingrediënt> list){
        StringBuilder builder = new StringBuilder();
        for (Ingrediënt ingredient:list) {
            if(ingredient.isAllergic()){
                builder.append(ingredient.getNaam() + ", ");
            }
        }
        return builder.toString();
    }

    //Checks if phone is connected to wifi
    public boolean checkWifi(NetworkInfo wifiCheck) {
        return wifiCheck.isConnected();
    }

    public boolean randomBoolean(){
        Random random = new Random();
        int a = random.nextInt(3);
        if(a == 1){
            return true;
        }
        return false;
    }

    public Gebruiker logIn(String email, String wachtwoord){


        return null;
    }

}
