package com.example.kookpagin.Domain;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Gebruiker implements Parcelable {
    private Integer userID;
    private String firstName;
    private String lastName;
    private String emailAdress;
    private String telefoonNummer;
    private String password;
    private boolean isActief;
    private String city;
    private String street;
    private String role;

    public Gebruiker(Integer ID, String voorNaam, String achterNaam, String emailAddress, String telefoonNummer, String wachtWoord, String city, String street, boolean isActief) {
        this.userID = ID;
        this.firstName = voorNaam;
        this.lastName = achterNaam;
        this.emailAdress = emailAddress;
        this.telefoonNummer = telefoonNummer;
        this.password = wachtWoord;
        this.isActief = isActief;
        this.city = city;
        this.street = street;
    }

    public Gebruiker(Integer ID, String voorNaam, String achterNaam, String emailAddress, String telefoonNummer, String city, String street, String role){
        this.userID = ID;
        this.firstName = voorNaam;
        this.lastName = achterNaam;
        this.emailAdress = emailAddress;
        this.telefoonNummer = telefoonNummer;
        this.password = "";
        this.isActief = true;
        this.city = city;
        this.street = street;
        this.role = role;
    }

    protected Gebruiker(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        emailAdress = in.readString();
        telefoonNummer = in.readString();
        password = in.readString();
        userID = in.readInt();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            isActief = in.readBoolean();
        }
        city = in.readString();
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
        return firstName;
    }

    public void setVoorNaam(String voorNaam) {
        firstName = voorNaam;
    }

    public String getAchterNaam() {
        return lastName;
    }

    public void setAchterNaam(String achterNaam) {
        lastName = achterNaam;
    }

    public String getEmailAddress() {
        return emailAdress;
    }

    public void setActief(boolean actief) {
        isActief = actief;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAdress = emailAddress;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public String getWachtWoord() {
        return password;
    }

    public void setWachtWoord(String wachtWoord) {
        this.password = wachtWoord;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(firstName);
        parcel.writeString(lastName);
        parcel.writeString(emailAdress);
        parcel.writeString(telefoonNummer);
        parcel.writeString(password);
        parcel.writeInt(userID);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            parcel.writeBoolean(isActief);
        }
        parcel.writeString(city);
        parcel.writeString(street);
        parcel.writeString(role);
    }

    public String getStad() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public boolean isActief() {
        return isActief;
    }
    @NonNull
    @Override
    public String toString() {
        return String.format("%s:%s:%s:%s:%s:%s:%s:%s:%s:%s", userID,firstName,lastName,emailAdress,telefoonNummer,password,isActief,city,street,role);
    }
}
