package com.example.kookpagin.Logic;

import android.util.Log;

import com.example.kookpagin.Data.AsyncDataOphalers.DaoInterface;
import com.example.kookpagin.Domain.DomainFactory;
import com.example.kookpagin.Domain.Ingrediënt;

import java.util.List;

public class applicatieLogica {
    private DaoInterface dataOpslag;
    private DomainFactory factory;
    private static final String Logic = "Logica";

    public applicatieLogica(DaoInterface soort, DomainFactory factory) {
        this.dataOpslag = soort;
        this.factory = factory;
    }

    //Maakt een allergenen string
    public String geefAllergenenTerug(List<Ingrediënt> list){
        StringBuilder builder = new StringBuilder();
        if(list.isEmpty()){
            Log.e(Logic,"Er zijn geen allergenen");
            return "Niets";

        }
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).isAllergic() && i < list.size() - 2){
                builder.append(list.get(i).getNaam() + ",");
            } else{
                builder.append(list.get(i).getNaam());
            }
        }
        Log.e(Logic,"Allergenen succesvol toegevoegd");
        return builder.toString();
    }


}
