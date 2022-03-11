package com.example.kookpagin;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kookpagin.Domain.DomainFactory;
import com.example.kookpagin.Domain.Gebruiker;

public class Registratie extends AppCompatActivity {
    private EditText mVoor;
    private EditText mAchter;
    private EditText mMail;
    private EditText mTele;
    private EditText mPw;
    private EditText mStad;
    private EditText mStraat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registratie);

        mVoor = findViewById(R.id.VoornaamVeld);
        mAchter= findViewById(R.id.achternaamVeld);
        mMail = findViewById(R.id.emailVeld);
        mTele = findViewById(R.id.TelefoonNummerVeld);
        mPw = findViewById(R.id.wachtwoordVeld);
        mStad = findViewById(R.id.stadVeld);
        mStraat = findViewById(R.id.Straatveld);
    }

    public void registratie(View view) {
        //Id wordt niet gebruikt
        int id = -1;
        String voornaam = mVoor.getText().toString();
        String achternaam = mAchter.getText().toString();
        String mail = mMail.getText().toString();
        String telefoon = mTele.getText().toString();
        String ww = mPw.getText().toString();
        String stad= mStad.getText().toString();
        String straat = mStraat.getText().toString();
        String rol = "";
        Gebruiker user = DomainFactory.maakGebruikerZonderWW(id, voornaam,achternaam,mail, telefoon, ww,stad, straat,true);
        Toast.makeText(this,"Gebruiker aangemaakt", Toast.LENGTH_SHORT).show();
    }


}