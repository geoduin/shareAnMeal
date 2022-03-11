package com.example.kookpagin.Data.api;

import android.net.Uri;
import android.util.Log;

import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.Maaltijd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Netwerk {
    //De url voor de API om alle maaltijden op te halen
    private static final String DB_Alle_Maaltijden_URL = "https://shareameal-api.herokuapp.com/api/meal";
    //Basis url om gebruiker op te halen
    private static final String DB_user_Url = "https://shareameal-api.herokuapp.com/api/user";

    public static String haalAlleMaaltijdenOp(){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String JSON_String = null;

        try{
            Uri rawString = Uri.parse(DB_Alle_Maaltijden_URL).buildUpon().build();
            URL url = new URL(rawString.toString());
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
                return null;
            }

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

    public static void InsertCommand(Maaltijd maaltijd){
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String JSON_String = null;


        try{
            Uri rawString = Uri.parse(DB_Alle_Maaltijden_URL).buildUpon().build();
            URL url = new URL(rawString.toString());
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream stream = urlConnection.getInputStream();
            //Insert command

            reader = new BufferedReader(new InputStreamReader(stream));
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
}
