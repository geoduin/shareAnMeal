package com.example.kookpagin.Domain.ResponseDomain;

import com.example.kookpagin.Domain.Maaltijd2;
import com.example.kookpagin.Domain.MaaltijdDetail;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MaaltijdResponse {

    @SerializedName("status")
    private int status;

    @SerializedName("result")
    private Maaltijd2[] meal;

    public MaaltijdResponse(int status, Maaltijd2[] meal) {
        this.status = status;
        this.meal = meal;
    }

    public int getStatus() {
        return status;
    }

    public Maaltijd2[] getMeal() {
        return meal;
    }
}
