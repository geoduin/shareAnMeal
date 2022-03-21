package com.example.kookpagin.Data;

import android.util.Log;

import com.example.kookpagin.Domain.DomainFactory;
import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.Ingrediënt;
import com.example.kookpagin.Domain.Locatie;
import com.example.kookpagin.Domain.Maaltijd;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

//Interface om snel Dao's te maken
//Ongebruikte klasse
public interface DaoInterface<T> {
    List<T> retrieve() throws ExecutionException, InterruptedException;
    boolean insert(T value);
    boolean update(T value);
    boolean delete(T value);
}
