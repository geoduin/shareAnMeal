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

    //Hoe moet je tabel maken met een object als attribuut binnen de domein klasse?

    public Maaltijd(String naam, String beschrijving, String AfbeeldingsUrl,double prijs, Locatie locatie, LocalDateTime datum, Gebruiker gebruiker, int maxBezoekers, boolean isActief, boolean takeAway, boolean IsVega, boolean isVegan){
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.AfbeeldingsUrl = AfbeeldingsUrl;
        this.datum = datum;
        this.OrginelePoster = gebruiker;
        this.deelnemers = new Gebruiker[maxBezoekers];
        this.ingredientenLijst = new ArrayList<>();
        this.allergenenLijst = new ArrayList<>();
        this.locatie = locatie;
        this.prijs = prijs;
        this.takeAway =takeAway;
        this.isActief = isActief;
        this.Vegan =isVegan;
        this.Vega = IsVega;
    }

    //Overloaded constructor voor het ophalen van bestaande maaltijden zonder locatie
    public Maaltijd(String naam, String beschrijving, String AfbeeldingsUrl,double prijs, LocalDateTime datum, Gebruiker gebruiker, int maxBezoekers, boolean isActief, boolean takeAway, boolean IsVega, boolean isVegan){
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.AfbeeldingsUrl = AfbeeldingsUrl;
        this.datum = datum;
        this.OrginelePoster = gebruiker;
        this.deelnemers = new Gebruiker[maxBezoekers];
        this.ingredientenLijst = new ArrayList<>();
        this.allergenenLijst = new ArrayList<>();
        this.prijs = prijs;
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
        locatie = in.readParcelable(Locatie.class.getClassLoader());
        OrginelePoster = in.readParcelable(Gebruiker.class.getClassLoader());
        deelnemers = in.createTypedArray(Gebruiker.CREATOR);
        ingredientenLijst = in.createTypedArrayList(Ingrediënt.CREATOR);
        allergenenLijst = in.createTypedArrayList(Ingrediënt.CREATOR);
        datum = (LocalDateTime)in.readSerializable();
        takeAway = in.readByte() != 0;
        isActief = in.readByte() != 0;
        Vega = in.readByte() != 0;
        Vegan = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(naam);
        dest.writeString(beschrijving);
        dest.writeString(AfbeeldingsUrl);
        dest.writeDouble(prijs);
        dest.writeParcelable(locatie, flags);
        dest.writeParcelable(OrginelePoster, flags);
        dest.writeTypedArray(deelnemers, flags);
        dest.writeTypedList(ingredientenLijst);
        dest.writeTypedList(allergenenLijst);
        dest.writeSerializable(datum);
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

    public String getNaam() {
        return naam;
    }

    public String getAfbeeldingsUrl() {
        return AfbeeldingsUrl;
    }

    public void setAfbeeldingsUrl(String afbeeldingsUrl) {
        AfbeeldingsUrl = afbeeldingsUrl;
    }

    public LocalDateTime getDatum() {
        return datum;
    }

    public void setDatum(LocalDateTime datum) {
        this.datum = datum;
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

    public List<Ingrediënt> getIngredientenLijst() {
        return ingredientenLijst;
    }

    public void setIngredientenLijst(List<Ingrediënt> ingredientenLijst) {
        this.ingredientenLijst = ingredientenLijst;
    }

    public List<Ingrediënt> getAllergenenLijst() {
        return allergenenLijst;
    }

    public void setAllergenenLijst(List<Ingrediënt> allergenenLijst) {
        this.allergenenLijst = allergenenLijst;
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

    public String getBeschrijving() {
        return beschrijving;
    }

    public String getOPVoorEnAchterNaam(){
        return this.OrginelePoster.getVoorNaam() + " " +this.OrginelePoster.getAchterNaam();
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

    public String getStad(){
        if(locatie == null){
            return "Onbekend";
        }
        String stad = locatie.getPlaats();
        return stad;
    }

    public void setLocatie(String straatHnR, String postcode, String stad){
        this.locatie = new Locatie(straatHnR, postcode, stad);
    }

    public double getPrijs(){
        return  prijs;
    }

    public String haalDatumOp(){
        String date = this.datum.toString();
        return  date;
    }

    public void addAllergies(Ingrediënt ingredient){
        this.allergenenLijst.add(ingredient);
    }

    public void addIngredient(Ingrediënt ingredient){
        this.ingredientenLijst.add(ingredient);
    }
}
