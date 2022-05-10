package com.example.kookpagin.Domain.ResponseDomain;

import com.example.kookpagin.Domain.MaaltijdDetail;
import com.google.gson.annotations.SerializedName;

public class MaaltijdDetailResponse {

    @SerializedName("status")
    private int statusCode;
    @SerializedName("result")
    private MaaltijdDetail maaltijd;

    public MaaltijdDetailResponse(int statusCode, MaaltijdDetail maaltijd) {
        this.statusCode = statusCode;
        this.maaltijd = maaltijd;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public MaaltijdDetail getMaaltijdDetail() {
        return maaltijd;
    }

}
