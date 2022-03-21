package com.example.kookpagin.Domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Maaltijd implements Parcelable {
    private String naam;
    private String beschrijving;
    private String AfbeeldingsUrl;
    private double prijs;
    private LocalDateTime datum;
    private Locatie locatie;
    private Gebruiker OrginelePoster;
    private Gebruiker[] deelnemers;
    private List<Ingrediënt>ingredientenLijst;
    private List<Ingrediënt>allergenenLijst;
    private boolean takeAway;
    private boolean isActief;
    private boolean Vega;
    private boolean Vegan;

    public Maaltijd(String naam, String beschrijving, String afbeeldingsUrl, double prijs, LocalDateTime datum, Locatie locatie, Gebruiker orginelePoster, boolean takeAway, boolean isActief, boolean vega, boolean vegan, int deelnemers) {
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.AfbeeldingsUrl = afbeeldingsUrl;
        this.prijs = prijs;
        this.datum = datum;
        this.locatie = locatie;
        OrginelePoster = orginelePoster;
        this.deelnemers = new Gebruiker[deelnemers];
        this.ingredientenLijst = new ArrayList<>();
        this.allergenenLijst = new ArrayList<>();;
        this.takeAway = takeAway;
        this.isActief = isActief;
        Vega = vega;
        Vegan = vegan;
    }

    //Overloaded constructor voor het ophalen van bestaande maaltijden zonder locatie
    public Maaltijd(String naam, String beschrijving, String AfbeeldingsUrl,double prijs, LocalDateTime datum, Gebruiker gebruiker, int maxBezoekers, boolean isActief, boolean takeAway, boolean IsVega, boolean isVegan){
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.AfbeeldingsUrl = AfbeeldingsUrl;
        this.prijs = prijs;
        this.datum = datum;
        this.locatie = getLocatie();
        this.OrginelePoster = gebruiker;
        this.deelnemers = new Gebruiker[maxBezoekers];
        this.ingredientenLijst = new ArrayList<>();
        this.allergenenLijst = new ArrayList<>();
        this.takeAway =takeAway;
        this.isActief = isActief;
        this.Vegan =isVegan;
        this.Vega = IsVega;
    }

    protected Maaltijd(Parcel in) {
        naam = in.readString();
        beschrijving = in.readString();
        AfbeeldingsUrl = in.readString();
        prijs = in.readDouble();
        datum = (LocalDateTime) in.readSerializable();
        locatie = in.readParcelable(Locatie.class.getClassLoader());
        OrginelePoster = in.readParcelable(Gebruiker.class.getClassLoader());
        deelnemers = in.createTypedArray(Gebruiker.CREATOR);
        ingredientenLijst = in.createTypedArrayList(Ingrediënt.CREATOR);
        allergenenLijst = in.createTypedArrayList(Ingrediënt.CREATOR);
        takeAway = in.readByte() != 0;
        isActief = in.readByte() != 0;
        Vega = in.readByte() != 0;
        Vegan = in.readByte() != 0;
    }
    public String getStad(){
        if(locatie == null){
            return "Onbekend";
        }
        String stad = locatie.getPlaats();
        return stad;
    }

    public String haalDatumOp(){
        String date = this.datum.toString();
        return  date;
    }
    public String getOPVoorEnAchterNaam(){
        return this.OrginelePoster.getVoorNaam() + " " +this.OrginelePoster.getAchterNaam();
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public void setAfbeeldingsUrl(String afbeeldingsUrl) {
        AfbeeldingsUrl = afbeeldingsUrl;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
    }

    public void setLocatie(Locatie locatie) {
        this.locatie = locatie;
    }

    public void setOrginelePoster(Gebruiker orginelePoster) {
        OrginelePoster = orginelePoster;
    }

    public void setDeelnemers(Gebruiker[] deelnemers) {
        this.deelnemers = deelnemers;
    }

    public void setIngredientenLijst(List<Ingrediënt> ingredientenLijst) {
        this.ingredientenLijst = ingredientenLijst;
    }

    public void setAllergenenLijst(List<Ingrediënt> allergenenLijst) {
        this.allergenenLijst = allergenenLijst;
    }

    public void setTakeAway(boolean takeAway) {
        this.takeAway = takeAway;
    }

    public void setActief(boolean actief) {
        isActief = actief;
    }

    public void setVega(boolean vega) {
        Vega = vega;
    }

    public void setVegan(boolean vegan) {
        Vegan = vegan;
    }

    public String getNaam() {
        return naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getAfbeeldingsUrl() {
        return AfbeeldingsUrl;
    }

    public double getPrijs() {
        return prijs;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public String haalDatum(){
        int day = datum.getDayOfMonth();
        int month = datum.getMonthValue();
        int year = datum.getYear();
        return String.format("%s-%s-%s", day,month,year);
    }

    public Locatie getLocatie() {
        return locatie;
    }

    public Gebruiker getOrginelePoster() {
        return OrginelePoster;
    }

    public Gebruiker[] getDeelnemers() {
        return deelnemers;
    }

    public List<Ingrediënt> getIngredientenLijst() {
        return ingredientenLijst;
    }

    public List<Ingrediënt> getAllergenenLijst() {
        return allergenenLijst;
    }

    public boolean isTakeAway() {
        return takeAway;
    }

    public boolean isActief() {
        return isActief;
    }

    public boolean isVega() {
        return Vega;
    }

    public boolean isVegan() {
        return Vegan;
    }

    public static Creator<Maaltijd> getCREATOR() {
        return CREATOR;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(naam);
        dest.writeString(beschrijving);
        dest.writeString(AfbeeldingsUrl);
        dest.writeDouble(prijs);
        dest.writeSerializable(datum);
        dest.writeParcelable(locatie, flags);
        dest.writeParcelable(OrginelePoster, flags);
        dest.writeTypedArray(deelnemers, flags);
        dest.writeTypedList(ingredientenLijst);
        dest.writeTypedList(allergenenLijst);
        dest.writeByte((byte) (takeAway ? 1 : 0));
        dest.writeByte((byte) (isActief ? 1 : 0));
        dest.writeByte((byte) (Vega ? 1 : 0));
        dest.writeByte((byte) (Vegan ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Maaltijd> CREATOR = new Creator<Maaltijd>() {
        @Override
        public Maaltijd createFromParcel(Parcel in) {
            return new Maaltijd(in);
        }

        @Override
        public Maaltijd[] newArray(int size) {
            return new Maaltijd[size];
        }
    };

}
