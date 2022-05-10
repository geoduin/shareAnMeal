package com.example.kookpagin.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Logic.applicatieLogica;
import com.example.kookpagin.MainActivity;
import com.example.kookpagin.R;
import com.example.kookpagin.UI.viewModels.GebruikerViewModel;

public class InlogScherm extends AppCompatActivity {
    private EditText mEmail;
    private EditText mWachtwoord;
    private applicatieLogica mLogica;
    public static final String gebruikerKey= "key";
    public static final String logInlog= "inlogClass";
    private GebruikerViewModel mGebruikerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inlog_scherm);
        Log.i(logInlog, "Log in gemaakt");
        mGebruikerModel = ViewModelProviders.of(this).get(GebruikerViewModel.class);
        mGebruikerModel.getGebruiker().observe(this, gebruiker->{
            Intent intent = new Intent(this, MainActivity.class);
            Toast.makeText(this, "User: " + gebruiker.getEmailAdress() + "has logged in", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK, intent);
            finish();
        });
        loadUI();
    }

    public void loadUI(){
        mEmail = findViewById(R.id.EmailAddressField);
        mWachtwoord = findViewById(R.id.wachtwoordVeld);
    }


    public void logIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String email = mEmail.getText().toString();
        String wachtwoord = mWachtwoord.getText().toString();
        mGebruikerModel.applyLogin(email, wachtwoord);
        Log.e(logInlog, "Functionaliteit nog niet in werking");
//        intent.putExtra(gebruikerKey, user);
//        setResult(RESULT_OK, intent);
//        finish();
    }

    public void registeren(View view) {
        Intent intent = new Intent(this, Registratie.class);
        startActivity(intent);
        Log.w(logInlog, "Placeholder methode. Doet niets");
    }
}