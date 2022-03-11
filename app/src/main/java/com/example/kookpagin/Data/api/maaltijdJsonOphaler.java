package com.example.kookpagin.Data.api;


import android.os.AsyncTask;

import com.example.kookpagin.Domain.DomainFactory;
import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.Locatie;
import com.example.kookpagin.Domain.Maaltijd;
import com.example.kookpagin.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class maaltijdJsonOphaler extends AsyncTask<Void, Void, String> {
    private List<Maaltijd>maaltijdenLijst;
    private MainActivity main;

    public maaltijdJsonOphaler(){
        this.maaltijdenLijst = new ArrayList<>();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return Netwerk.haalAlleMaaltijdenOp();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

}