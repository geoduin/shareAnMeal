package com.example.kookpagin.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.kookpagin.Data.DaoInterface;
import com.example.kookpagin.Domain.DomainFactory;
import com.example.kookpagin.Domain.Ingrediënt;
import com.example.kookpagin.Domain.Maaltijd;
import com.example.kookpagin.Logic.applicatieLogica;
import com.example.kookpagin.R;

import java.time.LocalDate;
import java.util.List;

public class detailPagina extends AppCompatActivity {
    private static String tag = "Jul";
    private applicatieLogica logica;
    private ImageView image;
    private ImageView profiel;
    private TextView naam;
    private TextView titel;
    private TextView beschrijving;
    private TextView allergenen;
    private TextView datum;
    private TextView stad;
    private CheckBox vegan;
    private CheckBox vega;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pagina);
        Log.d("OnCreate", getString(R.string.Details_Realisatie));
        DaoInterface DaoDB = null;
        logica = new applicatieLogica(DaoDB, new DomainFactory());
        Intent intent = getIntent();
        Maaltijd maaltijd = (Maaltijd)intent.getParcelableExtra(tag);
        saveFieldsToClass();
        fillActivityLayout(maaltijd);
    }

    //Wijst onderdelen toe aan de xml
    public void saveFieldsToClass(){
        image = findViewById(R.id.MaaltijdFoto);
        naam = findViewById(R.id.Naam);
        titel = findViewById(R.id.titel);
        stad = findViewById(R.id.StadNaam);
        beschrijving = findViewById(R.id.Tekst);
        allergenen = findViewById(R.id.AllergenenLijst);
        datum = findViewById(R.id.date);
        vega = findViewById(R.id.Vega);
        vegan = findViewById(R.id.Vegan);
        profiel = findViewById(R.id.profiel);
        Log.d("OnCreate", getString(R.string.UIassignment));
    }

    //Vult alle views in
    public void fillActivityLayout(Maaltijd maaltijd){
        Glide.with(this).load(maaltijd.getAfbeeldingsUrl()).into(image);
        naam.setText(maaltijd.getOPVoorEnAchterNaam());
        titel.setText(maaltijd.getNaam());
        stad.setText(maaltijd.getStad());
        beschrijving.setText(maaltijd.getBeschrijving());
        allergenen.setText(logica.geefAllergenenTerug(maaltijd.getAllergenenLijst()));
        datum.setText(maaltijd.haalDatum());
        vega.setChecked(maaltijd.isVega());
        vegan.setChecked(maaltijd.isVegan());
        //Placeholder pasfoto
        Glide.with(this).load(R.drawable.ic_optie).into(profiel);
        Log.d("OnCreate", getString(R.string.UIinvulling));
    }

    //Ongebruikte methode
    public void aanmelding(View view) {
        Toast.makeText(this,"Aanmeld functie is nog niet toegevoegd",
                Toast.LENGTH_SHORT).show();
        Log.d("OnCreate", getString(R.string.toast));
    }
}