package com.example.kookpagin.Domain;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

public class Maaltijd2 {
    @SerializedName("id")
    private int id;
    @SerializedName("isToTakeHome")
    private int takeAway;
    @SerializedName("isActive")
    private int isActief;
    @SerializedName("isVega")
    private int Vega;
    @SerializedName("isVegan")
    private int Vegan;
    @SerializedName("dateTime")
    private String datum;
    @SerializedName("maxAmountOfParticipants")
    private Integer maxDeelnemers;
    @SerializedName("price")
    private Double prijs;
    @SerializedName("imageUrl")
    private String AfbeeldingsUrl;
    @SerializedName("cookId")
    private Integer cookId;
    @SerializedName("name")
    private String naam;
    @SerializedName("description")
    private String beschrijving;

//    @SerializedName("allergenes")
//    private String[] allergenenLijst;

//    @SerializedName("cook")
//    private MaaltijdGebruiker koker;

    //@SerializedName("participants")
    //private List<MaaltijdGebruiker> deelnemers;

    public Maaltijd2(int id, int takeAway, int isActief, int vega, int vegan, String datum, Integer maxDeelnemers, Double prijs, String afbeeldingsUrl, Integer cookId, String naam, String beschrijving) {
        this.id = id;
        this.takeAway = takeAway;
        this.isActief = isActief;
        Vega = vega;
        Vegan = vegan;
        this.datum = datum;
        this.maxDeelnemers = maxDeelnemers;
        this.prijs = prijs;
        AfbeeldingsUrl = afbeeldingsUrl;
        this.cookId = cookId;
        this.naam = naam;
        this.beschrijving = beschrijving;
    }
}
