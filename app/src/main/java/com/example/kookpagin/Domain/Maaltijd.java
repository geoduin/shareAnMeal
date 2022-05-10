package com.example.kookpagin.Domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maaltijd implements Serializable {
    @SerializedName("id")
    private int MaaltijdID;
    @SerializedName("name")
    private String naam;
    @SerializedName("description")
    private String beschrijving;
    @SerializedName("isToTakeHome")
    private boolean takeAway;
    @SerializedName("isActive")
    private boolean isActief;
    @SerializedName("isVega")
    private boolean Vega;
    @SerializedName("isVegan")
    private boolean Vegan;
    @SerializedName("dateTime")
    private String datum;
    @SerializedName("maxAmountOfParticipants")
    private int value;
    @SerializedName("price")
    private String prijs;
    @SerializedName("imageUrl")
    private String AfbeeldingsUrl;
    @SerializedName("allergenes")
    private List<String> allergenen;
    @SerializedName("cook")
    private Gebruiker OrginelePoster;
    @SerializedName("participants")
    private Gebruiker[] deelnemers;

    public Maaltijd(int maaltijdID, String naam, String beschrijving, boolean takeAway, boolean isActief, boolean vega, boolean vegan, String datum, int value, String prijs, String afbeeldingsUrl, List<String> allergenen, Gebruiker orginelePoster, Gebruiker[] deelnemers) {
        MaaltijdID = maaltijdID;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.takeAway = takeAway;
        this.isActief = isActief;
        Vega = vega;
        Vegan = vegan;
        this.datum = datum;
        this.value = value;
        this.prijs = prijs;
        AfbeeldingsUrl = afbeeldingsUrl;
        this.allergenen = allergenen;
        OrginelePoster = orginelePoster;
        this.deelnemers = deelnemers;
    }

    public String getOPVoorEnAchterNaam(){
        return this.OrginelePoster.getVoorNaam() + " " +this.OrginelePoster.getAchterNaam();
    }

    public String haalDatum(){
        datum = datum.replace("Z", "");
        LocalDateTime date = LocalDateTime.parse(datum);

       int day = date.getDayOfMonth();
       int month = date.getMonthValue();
       int year = date.getYear();
        return String.format("%s-%s-%s", day,month,year);
    }

    public int getMaaltijdID() {
        return MaaltijdID;
    }

    public void setMaaltijdID(int maaltijdID) {
        MaaltijdID = maaltijdID;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public boolean isTakeAway() {
        return takeAway;
    }

    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }

    public boolean isActief() {
        return isActief;
    }

    public void setActief(boolean actief) {
        isActief = actief;
    }

    public boolean isVega() {
        return Vega;
    }

    public void setVega(boolean vega) {
        Vega = vega;
    }

    public boolean isVegan() {
        return Vegan;
    }

    public void setVegan(boolean vegan) {
        Vegan = vegan;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getPrijs() {
        return prijs;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }

    public String getAfbeeldingsUrl() {
        return AfbeeldingsUrl;
    }

    public void setAfbeeldingsUrl(String afbeeldingsUrl) {
        AfbeeldingsUrl = afbeeldingsUrl;
    }

    public List<String> getAllergenen() {
        return allergenen;
    }

    public void setAllergenen(List<String> allergenen) {
        this.allergenen = allergenen;
    }

    public Gebruiker getOrginelePoster() {
        return OrginelePoster;
    }

    public void setOrginelePoster(Gebruiker orginelePoster) {
        OrginelePoster = orginelePoster;
    }

    public Gebruiker[] getDeelnemers() {
        return deelnemers;
    }

    public void setDeelnemers(Gebruiker[] deelnemers) {
        this.deelnemers = deelnemers;
    }

    public String getStad(){
        return OrginelePoster.getStad();
    }

    @Override
    public String toString() {
        return "Maaltijd{" +
                "MaaltijdID=" + MaaltijdID +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", takeAway=" + takeAway +
                ", isActief=" + isActief +
                ", Vega=" + Vega +
                ", Vegan=" + Vegan +
                ", datum=" + datum +
                ", value=" + value +
                ", prijs='" + prijs + '\'' +
                ", AfbeeldingsUrl='" + AfbeeldingsUrl + '\'' +
                ", allergenen=" + allergenen +
                ", OrginelePoster=" + OrginelePoster +
                ", deelnemers=" + Arrays.toString(deelnemers) +
                '}';
    }
}
