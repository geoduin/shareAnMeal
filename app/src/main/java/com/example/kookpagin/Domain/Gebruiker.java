package com.example.kookpagin.Domain;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Arrays;

public class Gebruiker implements Serializable {
    @SerializedName("id")
    private Integer userID;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("emailAdress")
    private String emailAdress;
    @SerializedName("phoneNumber")
    private String telefoonNummer;
    @SerializedName("isActive")
    private boolean isActief;
    @SerializedName("city")
    private String city;
    @SerializedName("street")
    private String street;
    @SerializedName("roles")
    private String[] role;

    public Gebruiker(Integer userID, String firstName, String lastName, String emailAdress, String telefoonNummer, boolean isActief, String city, String street, String[] role) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.telefoonNummer = telefoonNummer;
        this.isActief = isActief;
        this.city = city;
        this.street = street;
        this.role = role;
    }

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
        return String.format("%s:%s:%s:%s:%s:%s:%s:%s:%s", userID,firstName,lastName,emailAdress,telefoonNummer,isActief,city,street, Arrays.toString(role));
    }
}
