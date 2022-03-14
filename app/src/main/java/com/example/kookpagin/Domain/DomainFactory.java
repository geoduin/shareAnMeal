package com.example.kookpagin.Domain;

import java.time.LocalDateTime;

public class DomainFactory {

    public static Maaltijd maakMaaltijd(String naam, String beschrijving, String AfbeeldingsUrl,double prijs, Locatie locatie, LocalDateTime datum, Gebruiker gebruiker, int maxBezoekers, boolean isActief, boolean takeAway, boolean vega, boolean vegan){
        return new Maaltijd(naam, beschrijving, AfbeeldingsUrl, prijs, datum,locatie,  gebruiker,  isActief,  takeAway, vega, vegan, maxBezoekers);
    }

    public static Maaltijd MaaltijdZonderLocatie(String naam, String beschrijving, String AfbeeldingsUrl,double prijs, LocalDateTime datum, Gebruiker gebruiker, int maxBezoekers, boolean isActief, boolean takeAway, boolean vega, boolean vegan){
        return new Maaltijd(naam, beschrijving, AfbeeldingsUrl, prijs, datum, gebruiker, maxBezoekers,  isActief,  takeAway, vega, vegan);
    }

    public static Gebruiker maakGebruikerZonderWW(int id, String voorNaam, String achterNaam, String emailAddress, String telefoonNummer, String wachtwoord, String city, String street, boolean isActive){
        return new Gebruiker(id, voorNaam, achterNaam, emailAddress, telefoonNummer,wachtwoord, city,street,isActive);
    }
    public static Gebruiker maakGebruikerMetID(int id, String voorNaam, String achterNaam, String emailAddress, String telefoonNummer, String city, String street, String role){
        return new Gebruiker(id, voorNaam, achterNaam, emailAddress, telefoonNummer, city,street, role);
    }

    public static Ingrediënt maakIngrediënt(String naam, String afbeeldingUrl, boolean isAllergic){
        return new Ingrediënt(naam, afbeeldingUrl, isAllergic);
    }


}
