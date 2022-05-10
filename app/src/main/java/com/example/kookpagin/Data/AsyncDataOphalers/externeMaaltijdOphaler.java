package com.example.kookpagin.Data.AsyncDataOphalers;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.kookpagin.Data.MaaltijdExterneRepo;
import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.Maaltijd;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class externeMaaltijdOphaler extends AsyncTask<Void, Void, String>{
    private MaaltijdExterneRepo repo;
    public MutableLiveData<List<Maaltijd>> maaltijdenLijst;
    private static final String retrieveTag = "Retrieve";
    private static final String error =  "Error";

    public externeMaaltijdOphaler(Application app) {
        this.maaltijdenLijst = new MutableLiveData<>();
    }

    @Override
    protected String doInBackground(Void... voids) {
        Log.i(retrieveTag, "Ophalen JSON begonnen");
        return JSONOphaler.haalJSONAlleMaaltijden();
    }

//    @Override
//    protected void onPostExecute(String s) {
//        super.onPostExecute(s);
//        List<Maaltijd> menu;
//        menu = maaltijdenOphalen(s);
//        Log.i(retrieveTag, "Maaltijdenlijst compleet");
//        maaltijdenLijst.setValue(menu);
//    }

    public MutableLiveData<List<Maaltijd>> getAsyncMaaltijdenLijst() {
        return maaltijdenLijst;
    }

//    public List<Maaltijd> maaltijdenOphalen(String s) {
//        List<Maaltijd> maaltijdenLijst = new ArrayList<>();
//        try {
//            JSONObject jsonObject = new JSONObject(s);
//            JSONArray jsonArray = jsonObject.getJSONArray("result");
//            for(int i = 0;  i < jsonArray.length(); i++){
//                Locatie locatie = null;
//                Maaltijd maaltijd = kookMaaltijd(jsonArray, i);
//                maaltijd.setDeelnemers(deelnemers(jsonArray, i, maaltijd));
//                maaltijdenLijst.add(maaltijd);
//                Log.d(retrieveTag, String.valueOf(i));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Log.d("Retrieve", "Maaltijdenlijst gemaakt");
//        return maaltijdenLijst;
//    }

    public Gebruiker maakGebruiker(JSONArray array, int i){
        Gebruiker uploader = null;
        try {
            //Krijgt json string binnen
            JSONObject pokeBowl = array.getJSONObject(i);
            //JsonObject pakt op basis van de index de daarbijhorende cook attribuut
            JSONObject user = pokeBowl.getJSONObject("cook");
            StringBuilder build = new StringBuilder();
            //Loopt door de roles array om de rollen in een string vast te plakken.
            try{
                JSONArray roleArray = user.getJSONArray("roles");
                for (int k = 0; k < roleArray.length(); k++) {
                    String object = roleArray.getString(i);
                    build.append(object);
                    build.append(":");
                }
            }catch (JSONException e){
                Log.e(error, e.toString());
                e.printStackTrace();
            }
            //Op basis van de user object, haalt het de attributen op om een gebruiker aan te maken
            int id = user.getInt("id");
            String phoneNumber = user.getString("phoneNumber");
            String firstName = user.getString("firstName");
            String lastName = user.getString("lastName");
            String emailAddress = user.getString("emailAdress");
            String street = user.getString("street");
            String city = user.getString("city");
            String roles = build.toString();
            //Maakt gebruiker aan
            //uploader = DomainFactory.maakGebruikerMetID(id, firstName, lastName, emailAddress,phoneNumber, street, city, roles);
            Log.d(retrieveTag, "Gebruiker aangemaakt");
        } catch (JSONException e) {
            Log.e(error, e.toString());
            e.printStackTrace();
        }
        //Geeft gebruiker terug
        return uploader;
    }

//    public Gebruiker[] deelnemers(JSONArray array, int i, Maaltijd meal){
//        Gebruiker[] deelnemersLijst = meal.getDeelnemers();
//        try {
//            JSONObject pokeBowl = array.getJSONObject(i);
//            JSONArray deelnemers = pokeBowl.getJSONArray("participants");
//            for (int j = 0; j < deelnemers.length(); j++) {
//                JSONObject user = deelnemers.getJSONObject(j);
//                JSONArray roleArray = user.getJSONArray("roles");
//                StringBuilder build = new StringBuilder();
//                for (int k = 0; k < roleArray.length(); k++) {
//                    String object = roleArray.getString(i);
//                    build.append(object);
//                    build.append(":");
//                }
//                int id = user.getInt("id");
//                String phoneNumber = user.getString("phoneNumber");
//                String firstName = user.getString("firstName");
//                String lastName = user.getString("lastName");
//                String emailAddress = user.getString("emailAdress");
//                String street = user.getString("street");
//                String city = user.getString("city");
//                String roles = build.toString();
//                deelnemersLijst[j] = DomainFactory.maakGebruikerMetID(id, firstName, lastName, emailAddress,phoneNumber, street, city, roles);
//            }
//            Log.d(retrieveTag, "Deelnemers toegevoegd");
//        } catch (JSONException e) {
//            Log.e(error, e.toString());
//            e.printStackTrace();
//        }
//        return deelnemersLijst;
//    }

//    public Maaltijd kookMaaltijd(JSONArray array, int i){
//        Maaltijd meal = null;
//        try{
//            //Krijgt JSONArray String binnen met de index
//            JSONObject pokeBowl = array.getJSONObject(i);
//            //Wijst attributen toe, op basis van de json.
//            int id = pokeBowl.getInt("id");
//            String maaltijdNaam = pokeBowl.getString("name");
//            String beschrijving = pokeBowl.getString("description");
//            boolean isActive = pokeBowl.getBoolean("isActive");
//            boolean isVega = pokeBowl.getBoolean("isVega");
//            boolean isVegan =pokeBowl.getBoolean("isVegan");
//            boolean isToTakeHome = pokeBowl.getBoolean("isToTakeHome");
//            String dateTime = pokeBowl.getString("dateTime");
//            List<Ingrediënt>allergieS = new ArrayList<>();
//            try{
//                //Loopt door de allergenenlijst en voegt ze toe
//                JSONArray allergieLijst = pokeBowl.getJSONArray("allergenes");
//                for (int j = 0; j < allergieLijst.length(); j++) {
//                    String aa = allergieLijst.getString(j);
//                    allergieS.add(new Ingrediënt(aa,"", false ));
//                }
//            }catch(JSONException e){
//                Log.e(error, e.toString());
//                e.printStackTrace();
//            }
//            //Verwijdert de Z, zodat het omgezet kan worden naar LocalDateTime
//            dateTime = dateTime.replace("Z", "");
//            LocalDateTime date = LocalDateTime.parse(dateTime);
//            int maxAmountOfParticipants = pokeBowl.getInt("maxAmountOfParticipants");
//            String prijs = pokeBowl.getString("price");
//            Double price = Double.parseDouble(prijs);
//            String imageUrl = pokeBowl.getString("imageUrl");
//            Gebruiker uploader = maakGebruiker(array, i);
//            //Creeert locatie van maaltijd
//            Locatie locatie = DomainFactory.maakLocatie(uploader.getStreet(), "", uploader.getStad());
//            //Maakt een maaltijd
//            meal = DomainFactory.MaaltijdZonderLocatie(id, maaltijdNaam,beschrijving, imageUrl, price, date, uploader,maxAmountOfParticipants,isActive, isToTakeHome,isVega,isVegan);
//            //Wijst allergienlijst toe aan de maaltijd klasse
//            meal.setAllergenenLijst(allergieS);
//            meal.setLocatie(locatie);
//        } catch (JSONException e) {
//            Log.e(error, e.toString());
//            e.printStackTrace();
//        }
//        Log.d(retrieveTag, "Maaltijd aangemaakt aangemaakt");
//        return meal;
//    }
}
