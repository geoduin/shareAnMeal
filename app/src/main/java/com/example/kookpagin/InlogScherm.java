package com.example.kookpagin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Logic.applicatieLogica;

public class InlogScherm extends AppCompatActivity {
    private EditText mEmail;
    private EditText mWachtwoord;
    private applicatieLogica mLogica;
    public static final String gebruikerKey= "ujdnn@rewf22";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inlog_scherm);

        mEmail = findViewById(R.id.EmailAddressField);
        mWachtwoord = findViewById(R.id.wachtwoordVeld);
    }

    public void logIn(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        String email = mEmail.getText().toString();
        String wachtwoord = mWachtwoord.getText().toString();
        Gebruiker user = new Gebruiker(1,"Xin", "Xiang", "Xin20Wang@outlook.com", "097789", "Lekker", "Rotterdam","kLEINEStraat",true);
        //Inlog functionaliteit



        intent.putExtra(gebruikerKey, user);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void registeren(View view) {
    }
}