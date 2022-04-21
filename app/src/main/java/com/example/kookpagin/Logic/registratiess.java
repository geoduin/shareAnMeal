package com.example.kookpagin.Logic;

import android.os.AsyncTask;

import com.example.kookpagin.Domain.Gebruiker;

public class registratiess extends AsyncTask<Gebruiker, Void, Void> {
    @Override
    protected Void doInBackground(Gebruiker... gebruikers) {
        JSONOphaler.InsertCommand(gebruikers[0]);
        return null;
    }
}
