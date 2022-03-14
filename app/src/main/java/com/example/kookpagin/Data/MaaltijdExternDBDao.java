package com.example.kookpagin.Data;

import android.util.Log;

import com.example.kookpagin.Data.api.maaltijdJsonOphaler;
import com.example.kookpagin.Domain.DomainFactory;
import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.Locatie;
import com.example.kookpagin.Domain.Maaltijd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MaaltijdExternDBDao implements DaoInterface<Maaltijd>{
    private static final String retrieveTag = "Retrieve";
    private maaltijdJsonOphaler asyncTask;
    public MaaltijdExternDBDao(maaltijdJsonOphaler loper) {
        asyncTask = loper;
    }
    @Override
    public List<Maaltijd> retrieve() throws ExecutionException, InterruptedException {
        List<Maaltijd>box = new ArrayList<>();
        String JSONString = asyncTask.execute().get();
        if(JSONString == null){
            return box;
        }
        box = maaltijdenOphalen(JSONString);
        return box;
    }

    @Override
    public boolean insert(Maaltijd value) {
        return false;
    }

    @Override
    public boolean update(Maaltijd value) {
        return false;
    }

    @Override
    public boolean delete(Maaltijd value) {
        return false;
    }

    public List<Maaltijd> maaltijdenOphalen(String s) {
        List<Maaltijd> maaltijdenLijst = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("result");
            for(int i = 0;  i < jsonArray.length(); i++){
                //Locatie ontbreekt
                Locatie locatie = null;
                Maaltijd maaltijd = kookMaaltijd(jsonArray, i);
                maaltijd.setDeelnemers(deelnemers(jsonArray, i, maaltijd));
                maaltijdenLijst.add(maaltijd);
                //Allergenenlijst/Optioneel
                //IngredientenLijst/Optioneel
                //while (allergenen.length()> 0){
                //Uitzoeken om een lijst van arrays te maken
                //JSONObject haatTrein = allergenen.getJSONObject(j);
                //allergeLijst.add(new Ingrediënt())
                //j++;
                //}
                Log.d(retrieveTag, String.valueOf(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("Retrieve", "Maaltijdenlijst gemaakt");
        return maaltijdenLijst;
    }

    public Gebruiker maakGebruiker(JSONArray array, int i){
        Gebruiker uploader = null;
        try {
            JSONObject pokeBowl = array.getJSONObject(i);
            JSONObject user = pokeBowl.getJSONObject("cook");
            StringBuilder build = new StringBuilder();
            try{
                JSONArray roleArray = user.getJSONArray("role");
                for (int k = 0; k < roleArray.length(); k++) {
                    String object = roleArray.getString(i);
                    build.append(object);
                    build.append(":");
                }
            }catch (JSONException e){
                e.printStackTrace();
            }
            int id = user.getInt("id");
            String phoneNumber = user.getString("phoneNumber");
            String firstName = user.getString("firstName");
            String lastName = user.getString("lastName");
            String emailAddress = user.getString("emailAdress");
            String street = user.getString("street");
            String city = user.getString("city");
            String roles = build.toString();
            uploader = DomainFactory.maakGebruikerMetID(id, firstName, lastName, emailAddress,phoneNumber, street, city, roles);
            Log.d(retrieveTag, "Gebruiker aangemaakt");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return uploader;
    }

    public Gebruiker[] deelnemers(JSONArray array, int i, Maaltijd meal){
        Gebruiker[] deelnemersLijst = meal.getDeelnemers();
        try {
            JSONObject pokeBowl = array.getJSONObject(i);
            JSONArray deelnemers = pokeBowl.getJSONArray("participants");
            for (int j = 0; j < deelnemers.length(); j++) {
                JSONObject user = deelnemers.getJSONObject(j);
                JSONArray roleArray = user.getJSONArray("role");
                StringBuilder build = new StringBuilder();
                for (int k = 0; k < roleArray.length(); k++) {
                    String object = roleArray.getString(i);
                    build.append(object);
                    build.append(":");
                }
                int id = user.getInt("id");
                String phoneNumber = user.getString("phoneNumber");
                String firstName = user.getString("firstName");
                String lastName = user.getString("lastName");
                String emailAddress = user.getString("emailAdress");
                String street = user.getString("street");
                String city = user.getString("city");
                String roles = build.toString();
                deelnemersLijst[j] = DomainFactory.maakGebruikerMetID(id, firstName, lastName, emailAddress,phoneNumber, street, city, roles);
            }
            Log.d(retrieveTag, "Deelnemers toegevoegd");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return deelnemersLijst;
    }

    public Maaltijd kookMaaltijd(JSONArray array, int i){
        Maaltijd meal = null;
        try{
            JSONObject pokeBowl = array.getJSONObject(i);
            String maaltijdNaam = pokeBowl.getString("name");
            String beschrijving = pokeBowl.getString("description");
            boolean isActive = pokeBowl.getBoolean("isActive");
            boolean isVega = pokeBowl.getBoolean("isVega");
            boolean isVegan =pokeBowl.getBoolean("isVegan");
            boolean isToTakeHome = pokeBowl.getBoolean("isToTakeHome");
            String dateTime = pokeBowl.getString("dateTime");
            dateTime = dateTime.replace("Z", "");
            LocalDateTime date = LocalDateTime.parse(dateTime);
            int maxAmountOfParticipants = pokeBowl.getInt("maxAmountOfParticipants");
            String prijs = pokeBowl.getString("price");
            Double price = Double.parseDouble(prijs);
            String imageUrl = pokeBowl.getString("imageUrl");
            Gebruiker uploader = maakGebruiker(array, i);
            meal = DomainFactory.MaaltijdZonderLocatie(maaltijdNaam,beschrijving, imageUrl, price, date, uploader,maxAmountOfParticipants,isActive, isToTakeHome,isVega,isVegan);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d(retrieveTag, "Maaltijd aangemaakt aangemaakt");
        return meal;
    }
}
