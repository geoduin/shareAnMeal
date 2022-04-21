package com.example.kookpagin.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class FilterMenu extends AppCompatActivity {
    public static final String KEY_VEGAN = "veganKey";
    public static final String KEY_VEGA = "vegaKey";
    public static final String KEY_LOCATION = "LocatieKey";
    public static final String KEY_INGREDIENT = "ingredientFilter";
    public static final String KEY_ALLERGY = "allergyFilter";
    public static final String logFilter = "allergyFilter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(logFilter, "Menu aangemaakt");
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(logFilter, "Pause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();Log.w(logFilter, "Destroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(logFilter, "Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(logFilter, "Resume");
    }
}