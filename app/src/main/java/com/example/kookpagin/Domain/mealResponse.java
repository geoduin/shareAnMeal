package com.example.kookpagin.Domain;

import java.util.List;

import retrofit2.http.Path;

public class mealResponse {

    private List<Maaltijd> list;

    public mealResponse(List<Maaltijd> list){
        this.list = list;
    }

    public List<Maaltijd> getList() {
        return list;
    }
}
