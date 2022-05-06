package com.example.kookpagin.Domain.ResponseDomain;

import com.example.kookpagin.Domain.Maaltijd;

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
