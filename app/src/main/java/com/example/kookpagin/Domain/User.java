package com.example.kookpagin.Domain;

public class User {
    // Deze attributen komen uit de api definitie

    private String id;
    public String firstName;
    public String lastName;
    private Boolean isActive;
    private String emailAdress;
    private String password;
    private String phoneNumber;
    private String token;

    public User(String id, String firstName, String lastName, Boolean isActive, String emailAdress, String password, String phoneNumber, String token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = isActive;
        this.emailAdress = emailAdress;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.token = token;
    }

    public String getEmailAdress() {
        return emailAdress;
    }

    public String getToken() {
        return token;
    }

    public String getDisplayName() {
        return this.firstName + " " + this.lastName;
    }
}
