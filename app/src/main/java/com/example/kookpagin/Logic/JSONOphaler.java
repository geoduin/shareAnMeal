package com.example.kookpagin.Logic;

import android.net.Uri;
import android.util.Log;

import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.LoginResponse;
import com.example.kookpagin.Domain.Maaltijd;
import com.example.kookpagin.Domain.mealResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.Path;
import retrofit2.converter.gson.GsonConverterFactory;

public class JSONOphaler {
    //JSON Request
    private static final String DB_Alle_Maaltijden_URL = "https://shareameal-api.herokuapp.com/api/meal";
    private static final String DB_accoutn_urL = "https://shareameal-api.herokuapp.com/api/user";

    //Basis url om gebruiker op te halen
    //Ongebruikte methode
    private static final String DB_user_Url = "https://shareameal-api.herokuapp.com/api/user";

    public static String haalJSONAlleMaaltijden(){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String JSON_String = null;

        try{
            Uri rawString = Uri.parse(DB_Alle_Maaltijden_URL).buildUpon().build();
            URL url = new URL(rawString.toString());

            //Connectie met het internet maken
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream stream = urlConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder builder = new StringBuilder();
            String line;
            //Plakt de verschillende string regels aan elkaar.
            while ((line = reader.readLine()) != null){
                builder.append(line);
                builder.append("\n");
            }
            if (builder.length() == 0) {
                return null;
            }
            Log.d("tag", builder.toString());
            JSON_String = builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return JSON_String;
    }
    //Ongebruikte methode
    public static void InsertCommand(Gebruiker user){
        Gebruiker aa = user;
        String json = new Gson().toJson(aa);

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String JSON_String = null;


        try{
            Uri rawString = Uri.parse(DB_accoutn_urL).buildUpon().build();
            URL url = new URL(rawString.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            //urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Content-Type", "application/json; utf-8");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.setDoOutput(true);
            //urlConnection.connect();

            String jsonInputString = new Gson().toJson(aa);

            try(OutputStream os = urlConnection.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }



            try(BufferedReader br = new BufferedReader(
                    new InputStreamReader(urlConnection.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the connection and the buffered reader.
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //Ongebruikte methode
    public static String haalGebruikerJson(){

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String JSON_String = null;
        try{
            //Dit wijzigen voor
        Uri rawString = Uri.parse(DB_Alle_Maaltijden_URL).buildUpon().build();
        URL url = new URL(rawString.toString());

        // Open the network connection.
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        InputStream stream = urlConnection.getInputStream();
        reader = new BufferedReader(new InputStreamReader(stream));

        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null){
            builder.append(line);
            builder.append("\n");
        }
        if (builder.length() == 0) {
            // Stream was empty.  Exit without parsing.
            return null;
        }

        JSON_String = builder.toString();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        // Close the connection and the buffered reader.
        if (urlConnection != null) {
            urlConnection.disconnect();
        }
        if (reader != null) {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

        Log.d("Hello", JSON_String);
        return JSON_String;
    }

    public static void haalAlleMaaltijdenOpRetroFit(){
            try {
                Gson gson = new GsonBuilder().setLenient().create();
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://shareameal-api.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
                Ophaler haler = retrofit.create(Ophaler.class);

                LoginData body = new LoginData("j.doe@server.com", "secret");

                Call<LoginResponse> call = haler.login(body);
                Response<LoginResponse> response = call.execute();
                //Call<List<Maaltijd>> repos = haler.haalMaaltijdenOp();
                if(response.isSuccessful()) {
                    LoginResponse loginResponse = response.body();
                    Log.d("TAG", "Got result " + loginResponse.getResult().firstName);

                } else {
                    Log.d("TAG", "Error logging in: " + response.message());
                }

            } catch (IOException e){
                e.printStackTrace();
            }



    }

}
