package com.example.kookpagin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kookpagin.Data.DaoInterface;
import com.example.kookpagin.Domain.Gebruiker;
import com.example.kookpagin.Domain.Maaltijd;
import com.example.kookpagin.Domain.DomainFactory;
import com.example.kookpagin.Logic.applicatieLogica;
import com.example.kookpagin.UI.*;
import com.example.kookpagin.UI.viewModels.maaltijdenViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //String keys
    public static final int TEXT_REQUEST = 1;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String Debug = "Debugger";
    private static final String saveCode = MainActivity.class.toGenericString();
    public static final String hulpGebruiker= "Uniek";
    public static final String opslaanSleutel= "Sleutel";
    //Instantieren
    private applicatieLogica mLogica;
    private DaoInterface daoInterface;
    private List<Maaltijd>HuidigeMaaltijdenLijst;
    private MaaltijdAdapter restaurantAdapter;
    private Gebruiker mGebruiker;
    private maaltijdenViewModel mModel;
    private SharedPreferences voorkeuren;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("StartER", "Creeer gebruiker");
        //Gebruiker ophalen
        Intent intent = getIntent();
        Gebruiker user = intent.getParcelableExtra(hulpGebruiker);
        mGebruiker = user;

        //Instantieert Logica
        this.mLogica = new applicatieLogica(daoInterface, new DomainFactory());
        //wijst recyclerview layout toe aan recyclerview en instantieert adapter
        RecyclerView mRecyclerView = findViewById(R.id.recycleViewer);
        restaurantAdapter = new MaaltijdAdapter(this);
        mRecyclerView.setAdapter(restaurantAdapter);
        //Geeft een gridlayoutmanager door aan de recyclerView
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Laadt preferenceManager in
        PreferenceManager.setDefaultValues(this,R.xml.voorkeuren, false);
        voorkeuren = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean isVega = voorkeuren.getBoolean(FilterMenu.KEY_VEGA, false);
        Boolean isVegan = voorkeuren.getBoolean(FilterMenu.KEY_VEGAN, false);
        Toast.makeText(this, "IsVega: " + isVega , Toast.LENGTH_SHORT).show();

        //Gridlayoutmanager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));
        //Het maaltijdViewModel is geinstantieert
        //Elke keer als het de activiteit opstart.
        maaltijdenViewModel dummy = new maaltijdenViewModel(getApplication());
        //maaltijdenViewModel onCreateModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(maaltijdenViewModel.class);
        mModel = dummy;
        //Set isVegaFilter
        mModel.setVegaFilter(isVega);
        mModel.setVeganFilter(isVegan);
        Log.i("StartER", "Viewmodel boolean waardes ingevult");
        if(savedInstanceState == null) {
            mModel.haalMaaltijdenOp();
            //Observer
            mModel.getMaaltijdenBord().observe(this, maaltijds -> {
                HuidigeMaaltijdenLijst = maaltijds;
                mModel.setFilterMaaltijd(HuidigeMaaltijdenLijst);
                restaurantAdapter.setList(mModel.getFilterMaaltijd());
                toast(restaurantAdapter.getItemCount());
                Log.i(TAG, "Grootte lijst: " + HuidigeMaaltijdenLijst.size());
            });
        } else{
            HuidigeMaaltijdenLijst = savedInstanceState.getParcelableArrayList(saveCode);
            Log.i(Debug, "Lijst is opgehaalt");
            mModel.setFilterMaaltijd(HuidigeMaaltijdenLijst);
            restaurantAdapter.setList(mModel.getFilterMaaltijd());
            toast(restaurantAdapter.getItemCount());
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("StartER", getString(R.string.opslaan));
        outState.putParcelableArrayList(saveCode, (ArrayList<? extends Parcelable>) HuidigeMaaltijdenLijst);
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
            Intent intent = new Intent(this, FilterMenu.class);
            startActivity(intent);
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
        boolean isVega = voorkeuren.getBoolean(FilterMenu.KEY_VEGA, false);
        boolean isVegan = voorkeuren.getBoolean(FilterMenu.KEY_VEGAN, false);
        mModel.setVegaFilter(isVega);
        mModel.setVeganFilter(isVegan);

        if(HuidigeMaaltijdenLijst ==null ||  HuidigeMaaltijdenLijst.size() == 0){
            Log.i(Debug, "Lijst is leeg");
            super.onRestart();
        }else{
            mModel.setFilterMaaltijd(HuidigeMaaltijdenLijst);
            restaurantAdapter.setList(mModel.getFilterMaaltijd());
            Toast.makeText(this, "IsVega: " + isVega + " size: " + HuidigeMaaltijdenLijst.size(), Toast.LENGTH_SHORT).show();
            Log.i(Debug, "Lijst is gevult en adapter geupdated");
            super.onRestart();
        }

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("StartER", "Destroy");
    }
}