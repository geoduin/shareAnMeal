package com.example.kookpagin.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kookpagin.Domain.Maaltijd;
import com.example.kookpagin.R;

import java.util.ArrayList;
import java.util.List;

public class MaaltijdAdapter extends RecyclerView.Adapter<MaaltijdAdapter.MaaltijdHolder> {
    public static final String oke = "Jul";
    public static final String logger = "AdapterActie";
    private List<Maaltijd>list;
    private LayoutInflater mInflater;
    private Context mContext;

    //Instantieert adapter
    public MaaltijdAdapter(Context context){
        this.list = new ArrayList<>();
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
        Log.i(logger, "Adapter gemaakt");
    }

    //Maakt een viewholder klasse aan
    @Override
    public MaaltijdHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.maaltijd_recycle_item, parent, false);
        Log.i(logger, "Viewholder aangemaakt");
        return new MaaltijdHolder(view);
    }

    @Override
    public void onBindViewHolder(MaaltijdHolder holder, int position) {
        //Pakt de maaltijd op basis van de positie
        Maaltijd maaltijd = list.get(position);
        //Wijst de attributen toe aan ieder maaltijd_recycle_item binnen de holder
        holder.titel.setText(maaltijd.getNaam());
        holder.datum.setText(maaltijd.haalDatum());
        holder.prijs.setText(Double.toString(maaltijd.getPrijs()));
        holder.stad.setText(maaltijd.getStad());
        Glide.with(mContext).load(maaltijd.getAfbeeldingsUrl()).into(holder.image);
        Log.i(logger, "Maaltijd toegewezen aan een viewholder");
    }

    public void setList(List<Maaltijd> list) {
        this.list = list;
        //Ververst de adapter en lijst, in het geval dat de lijst veranderd en past de wijzigingen toe.
        notifyDataSetChanged();
        Log.i(logger, "Lijst veranderd");
    }

    @Override
    public int getItemCount() {
        Log.i(logger, "Itemcount is " + list.size());
        return list.size();
    }

    //Een inner viewholder klasse genaamd MaaltijdHolder
    class MaaltijdHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView image;
        private TextView titel;
        private TextView datum;
        private TextView stad;
        private TextView prijs;
        private Maaltijd mMaaltijd;

        //Wijst voor ieder item de views aan de xml-onderdelen
        public MaaltijdHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.afbeelding);
            titel = itemView.findViewById(R.id.titel);
            datum = itemView.findViewById(R.id.datum);
            stad =  itemView.findViewById(R.id.Stad);
            prijs = itemView.findViewById(R.id.prijs);
            Log.i(logger, "Viewholder geconstructureerd");
            itemView.setOnClickListener(this);
        }

        //Een onclick methode om de detailpagina van ieder maaltijd te openen
        @Override
        public void onClick(View view) {
            Log.i(logger, "Transitie naar detailPagina");
            mMaaltijd = list.get(getLayoutPosition());
            Intent intent = new Intent(mContext, detailPagina.class);
            intent.putExtra(oke, (Parcelable) mMaaltijd);
            mContext.startActivity(intent);
        }
    }
}
