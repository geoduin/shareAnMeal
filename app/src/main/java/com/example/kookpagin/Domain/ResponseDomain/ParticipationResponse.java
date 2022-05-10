package com.example.kookpagin.Domain.ResponseDomain;

import com.google.gson.annotations.SerializedName;

public class ParticipationResponse {

    @SerializedName("status")
    private Integer status;
    @SerializedName("currentlyParticipating")
    private Boolean mBValue;

    public ParticipationResponse(Integer status, Boolean mBValue) {
        this.status = status;
        this.mBValue = mBValue;
    }

    public Boolean getValue() {
        return mBValue;
    }

    public Integer getStatus() {
        return status;
    }
}
