package com.example.kookpagin.Domain;

import com.google.gson.annotations.SerializedName;

public class Profiel {
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
    @SerializedName("password")
    private String password;
    @SerializedName("isActive")
    private int isActief;
    @SerializedName("city")
    private String city;
    @SerializedName("street")
    private String street;
    @SerializedName("token")
    private String token;

    public Profiel(Integer userID, String firstName, String lastName, String emailAdress, String telefoonNummer, String password, int isActief, String city, String street, String token) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAdress = emailAdress;
        this.telefoonNummer = telefoonNummer;
        this.password = password;
        this.isActief = isActief;
        this.city = city;
        this.street = street;
        this.token = token;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getTelefoonNummer() {
        return telefoonNummer;
    }

    public void setTelefoonNummer(String telefoonNummer) {
        this.telefoonNummer = telefoonNummer;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsActief() {
        return isActief;
    }

    public void setIsActief(int isActief) {
        this.isActief = isActief;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
