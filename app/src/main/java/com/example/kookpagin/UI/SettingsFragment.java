package com.example.kookpagin.UI;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.SwitchPreferenceCompat;

import com.example.kookpagin.R;
import com.example.kookpagin.UI.FilterMenu;

public class SettingsFragment extends PreferenceFragmentCompat {
    private SwitchPreferenceCompat vega;
    private SwitchPreferenceCompat vegan;
    private static final String fragment=  "SharedPreferencemenu";
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.voorkeuren, rootKey);
        Log.i(fragment, "Fragment aangemaakt");
        SharedPreferences pref = androidx.preference.PreferenceManager.getDefaultSharedPreferences(getActivity());
        vega = (SwitchPreferenceCompat) findPreference(FilterMenu.KEY_VEGA);
        vegan =(SwitchPreferenceCompat) findPreference(FilterMenu.KEY_VEGAN);

        if(pref.getBoolean(FilterMenu.KEY_VEGA, true)){
            vegan.setEnabled(true);
            Log.i(fragment, "Vega is ingedrukt");
        } else{
            vegan.setEnabled(false);
            Log.i(fragment, "Vega is niet ingedrukt");
        }

        vega.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(@NonNull Preference preference, Object newValue) {
                Boolean isTurned = (Boolean) newValue;
                if(isTurned){
                    vegan.setEnabled(true);
                    Log.i(fragment, "Vegan optie is beschikbaar");
                } else{
                    vegan.setEnabled(false);
                    vegan.setChecked(false);
                    Log.i(fragment, "Vegan optie is niet beschikbaar");
                }

                return true;
            }
        });
    }
}