package com.example.kookpagin.Data.AsyncDataOphalers;

import android.os.AsyncTask;

import com.example.kookpagin.Data.AsyncDataOphalers.JSONOphaler;
import com.example.kookpagin.Domain.Gebruiker;

public class registratiess extends AsyncTask<Gebruiker, Void, Void> {
    @Override
    protected Void doInBackground(Gebruiker... gebruikers) {
        JSONOphaler.InsertCommand(gebruikers[0]);
        return null;
    }
}
