package com.example.kookpagin.Data;

import android.net.NetworkInfo;

import com.example.kookpagin.Data.api.maaltijdJsonOphaler;
import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.Maaltijd;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Repository {
    private DaoInterface Dao;

    public Repository(DaoInterface dao){
        Dao = dao;
    }

    public List<Maaltijd>retrieveData(NetworkInfo netwerk) throws ExecutionException, InterruptedException {
        boolean isConnected = netwerk.isConnected();
        if(isConnected){
            bepaalMaaltijdDao(isConnected);
            return Dao.retrieve();
        } else{
            bepaalMaaltijdDao(isConnected);
            return null;
        }
    }

    public Gebruiker haalGebruikerOp(String string, String wachtwoord){
        return null;
    }
    public void creeerMaaltijd(Maaltijd maaltijd){

    }

    public void updateMaaltijd(Maaltijd maaltijd){

    }

    public void verwijderMaaltijd(Maaltijd maaltijd){

    }

    public void bepaalMaaltijdDao(boolean isDec){
        if(isDec){
            this.Dao = new MaaltijdExternDBDao(new maaltijdJsonOphaler());
        } else{
            this.Dao = new InterneDBDao();
        }
    }
}
