package com.example.kookpagin.Data.AsyncDataOphalers;

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
