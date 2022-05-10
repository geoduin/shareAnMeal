package com.example.kookpagin.Domain;

import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.List;

public class MaaltijdDetail {
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
    private int maxDeelnemers;
    @SerializedName("price")
    private double prijs;
    @SerializedName("imageUrl")
    private String AfbeeldingsUrl;
    @SerializedName("name")
    private String naam;
    @SerializedName("description")
    private String beschrijving;
    @SerializedName("allergenes")
    private List<String> allergenenLijst;
    @SerializedName("cook")
    private MaaltijdGebruiker koker;

    // Later
    // @SerializedName("participants")
    // private List<Gebruiker> deelnemers;


    public MaaltijdDetail(int id, int takeAway, int isActief, int vega, int vegan, String datum, int maxDeelnemers, double prijs, String afbeeldingsUrl, String naam, String beschrijving, List<String> allergenenLijst, MaaltijdGebruiker koker) {
        this.id = id;
        this.takeAway = takeAway;
        this.isActief = isActief;
        Vega = vega;
        Vegan = vegan;
        this.datum = datum;
        this.maxDeelnemers = maxDeelnemers;
        this.prijs = prijs;
        AfbeeldingsUrl = afbeeldingsUrl;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.allergenenLijst = allergenenLijst;
        this.koker = koker;
    }

    @Override
    public String toString() {
        return "MaaltijdDetail{" +
                "id=" + id +
                ", takeAway=" + takeAway +
                ", isActief=" + isActief +
                ", Vega=" + Vega +
                ", Vegan=" + Vegan +
                ", datum=" + datum +
                ", maxDeelnemers=" + maxDeelnemers +
                ", prijs=" + prijs +
                ", AfbeeldingsUrl='" + AfbeeldingsUrl + '\'' +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", allergenenLijst=" + allergenenLijst +
                ", koker=" + koker +
                '}';
    }
}
