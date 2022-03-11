package com.example.kookpagin.Data;

import com.example.kookpagin.Domain.Gebruiker;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class userExternalDao implements DaoInterface<Gebruiker> {

    @Override
    public List<Gebruiker> retrieve() throws ExecutionException, InterruptedException {
        //Niet gebruikt
        return null;
    }

    @Override
    public boolean insert(Gebruiker value) {
        return false;
    }

    @Override
    public boolean update(Gebruiker value) {
        return false;
    }

    @Override
    public boolean delete(Gebruiker value) {
        return false;
    }

    public Gebruiker convertJsonNaarGebruiker(String value) {
        return null;
    }
}
