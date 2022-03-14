package com.example.kookpagin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kookpagin.Data.DaoInterface;
import com.example.kookpagin.Domain.*;
import com.example.kookpagin.Logic.*;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //String keys
    public static final int TEXT_REQUEST = 1;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String Debug = MainActivity.class.getCanonicalName();
    private static final String saveCode = MainActivity.class.toGenericString();
    public static final String hulpGebruiker= "Uniek";
    private DomainFactory mDomainFactory;
    private applicatieLogica mLogica;
    private DaoInterface daoInterface;
    private TextView wacht;
    private List<Maaltijd>maaltijdenLijst;
    private MaaltijdAdapter restaurantAdapter;
    private Gebruiker mGebruiker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("StartER", "Creeer gebruiker");
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);
        Log.d(TAG, "onCreate");

        //Later moet dit veranderen naar een lijst object
        Intent intent = getIntent();
        Gebruiker user = intent.getParcelableExtra(hulpGebruiker);
        mGebruiker = user;

        //Instantieert factory
        this.mDomainFactory = new DomainFactory();
        this.mLogica = new applicatieLogica(daoInterface, mDomainFactory);
        //wijst recyclerview layout toe aan recyclerview
        RecyclerView mRecyclerView = findViewById(R.id.recycleViewer);
        //Haalt testData op
        if(savedInstanceState != null){
            maaltijdenLijst = savedInstanceState.getParcelableArrayList(saveCode);
        } else{
            maaltijdenLijst = retrieveMealsFromInternet();
        }
        //instantieert adapter
        restaurantAdapter = new MaaltijdAdapter(this, maaltijdenLijst);
        //setAdapt in de recyclerview
        mRecyclerView.setAdapter(restaurantAdapter);
        //Geeft een gridlayoutmanager door aan de recyclerView
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        toast(maaltijdenLijst.toArray().length);
        Log.i("Start program", "Creeer gebruiker, aantal items: " + maaltijdenLijst.toArray().length);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(saveCode, getString(R.string.opslaan));
        outState.putParcelableArrayList(saveCode, (ArrayList<? extends Parcelable>) maaltijdenLijst);
    }

    //Laat top bar zien
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.d(TAG, getString(R.string.toolbar_creatie));
        getMenuInflater().inflate(R.menu.top_menu, menu);
        return true;
    }

    //Menu opties zien
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.setting) {
            Log.d(Debug, getString(R.string.selectie_optie)+ item.getItemId());
            return true;
        } else if(id == R.id.inlog){
            Log.d(Debug,getString(R.string.selectie_optie)+ item.getItemId());
            Intent intent = new Intent(this, InlogScherm.class);
            startActivityForResult(intent, 1);
        }
        return super.onOptionsItemSelected(item);
    }

    public void toast(int length){
        Log.i(Debug, getString(R.string.Maaltijden) + length);
        Toast.makeText(this, getString(R.string.Maaltijden)  +  length, Toast.LENGTH_SHORT).show();
    }

    public List<Maaltijd> retrieveMealsFromInternet(){
        List<Maaltijd> meals = null;
        Log.d(Debug, getString(R.string.Wifi_controle));
        ConnectivityManager connect = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifiCheck = null;
        if(connect != null) {
            wifiCheck = connect.getActiveNetworkInfo();
        }
        meals = mLogica.haalMaaltijdenOpUit(wifiCheck);
        return meals;
    }

    @Override
    protected void onStart() {
        Log.i("StartER", "ONSTART");
        Intent intent = getIntent();
        Gebruiker user = intent.getParcelableExtra(hulpGebruiker);
        mGebruiker = user;
        super.onStart();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("StartER", "Receive: " + requestCode + ", " + resultCode);
        if(requestCode == TEXT_REQUEST){
            if (resultCode == RESULT_OK){
                mGebruiker = data.getParcelableExtra(InlogScherm.gebruikerKey);
            }
        }
    }

    @Override
    protected void onRestart() {
        Log.i("StartER", "ONreSTART");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("StartER", "ONRESUME");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i("StartER", "ONPAUSE");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i("StartER", "STOP");
        super.onStop();
    }
}