package com.example.kookpagin.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Logic.applicatieLogica;
import com.example.kookpagin.MainActivity;
import com.example.kookpagin.R;

public class InlogScherm extends AppCompatActivity {
    private EditText mEmail;
    private EditText mWachtwoord;
    private applicatieLogica mLogica;
    public static final String gebruikerKey= "key";
    public static final String logInlog= "inlogClass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inlog_scherm);
        Log.i(logInlog, "Log in gemaakt");
        mEmail = findViewById(R.id.EmailAddressField);
        mWachtwoord = findViewById(R.id.wachtwoordVeld);
    }

    public void logIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String email = mEmail.getText().toString();
        String wachtwoord = mWachtwoord.getText().toString();
        Gebruiker user = new Gebruiker(1,"Xin", "Xiang", "Xin20Wang@outlook.com", "097789", "Lekker", "Rotterdam","kLEINEStraat",true);
        //Inlog functionaliteit
        Log.i(logInlog, "Gebruiker ingelogt");
        Log.w(logInlog, "Functionaliteit nog niet in werking");
        intent.putExtra(gebruikerKey, user);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void registeren(View view) {
        Log.w(logInlog, "Placeholder methode. Doet niets");
    }
}