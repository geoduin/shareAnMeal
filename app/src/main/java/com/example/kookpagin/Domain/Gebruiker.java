package com.example.kookpagin.Domain;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public class Gebruiker implements Parcelable {
    private Integer userID;
    private String VoorNaam;
    private String AchterNaam;
    private String emailAddress;
    private String telefoonNummer;
    private String wachtWoord;
    private boolean isActief;
    private String stad;
    private String street;
    private String role;

    public Gebruiker(int ID, String voorNaam, String achterNaam, String emailAddress, String telefoonNummer, String wachtWoord, String city, String street, boolean isActief) {
        this.userID = ID;
        this.VoorNaam = voorNaam;
        this.AchterNaam = achterNaam;
        this.emailAddress = emailAddress;
        this.telefoonNummer = telefoonNummer;
        this.wachtWoord = wachtWoord;
        this.isActief = isActief;
        this.stad = city;
        this.street = street;
    }

    public Gebruiker(int ID, String voorNaam, String achterNaam, String emailAddress, String telefoonNummer, String city, String street, String role){
        this.userID = ID;
        this.VoorNaam = voorNaam;
        this.AchterNaam = achterNaam;
        this.emailAddress = emailAddress;
        this.telefoonNummer = telefoonNummer;
        this.wachtWoord = "";
        this.isActief = true;
        this.stad = city;
        this.street = street;
        this.role = role;
    }

    protected Gebruiker(Parcel in) {
        VoorNaam = in.readString();
        AchterNaam = in.readString();
        emailAddress = in.readString();
        telefoonNummer = in.readString();
        wachtWoord = in.readString();
        userID = in.readInt();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            isActief = in.readBoolean();
        }
        stad = in.readString();
        street = in.readString();
        role = in.readString();
    }

    public static final Creator<Gebruiker> CREATOR = new Creator<Gebruiker>() {
        @Override
        public Gebruiker createFromParcel(Parcel in) {
            return new Gebruiker(in);
        }

        @Override
        public Gebruiker[] newArray(int size) {
            return new Gebruiker[size];
        }
    };

    public String getVoorNaam() {
        return VoorNaam;
    }

    public void setVoorNaam(String voorNaam) {
        VoorNaam = voorNaam;
    }

    public String getAchterNaam() {
        return AchterNaam;
    }

    public void setAchterNaam(String achterNaam) {
        AchterNaam = achterNaam;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setActief(boolean actief) {
        isActief = actief;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public String getWachtWoord() {
        return wachtWoord;
    }

    public void setWachtWoord(String wachtWoord) {
        this.wachtWoord = wachtWoord;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(VoorNaam);
        parcel.writeString(AchterNaam);
        parcel.writeString(emailAddress);
        parcel.writeString(telefoonNummer);
        parcel.writeString(wachtWoord);
        parcel.writeInt(userID);
        parcel.writeString(role);
        parcel.writeString(stad);
        parcel.writeString(street);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeBoolean(isActief);
        }
    }

    public boolean isActief() {
        return isActief;
    }
}
