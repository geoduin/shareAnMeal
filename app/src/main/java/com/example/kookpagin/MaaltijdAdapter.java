package com.example.kookpagin;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kookpagin.Domain.Maaltijd;

import java.util.List;

public class MaaltijdAdapter extends RecyclerView.Adapter<MaaltijdAdapter.MaaltijdBuffet> {
    public static final String oke = "Jul";
    private List<Maaltijd>list;
    private LayoutInflater mInflater;
    private Context mContext;

    MaaltijdAdapter(Context context, List<Maaltijd>list){
        this.list = list;
        this.mContext = context;
        this.mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public MaaltijdBuffet onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.maaltijd_recycle_item, parent, false);
        return new MaaltijdBuffet(view);
    }

    @Override
    public void onBindViewHolder(MaaltijdBuffet holder, int position) {
        Maaltijd maaltijd = list.get(position);
        //Binds to maaltijdbuffet
        holder.titel.setText(maaltijd.getNaam());
        holder.datum.setText(maaltijd.haalDatumOp());
        holder.prijs.setText(Double.toString(maaltijd.getPrijs()));
        holder.stad.setText(maaltijd.getStad());
        Glide.with(mContext).load(maaltijd.getAfbeeldingsUrl()).into(holder.image);
        holder.setMaaltijd(maaltijd);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MaaltijdBuffet extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView image;
        private TextView titel;
        private TextView datum;
        private TextView stad;
        private TextView prijs;
        private Maaltijd mMaaltijd;

        public MaaltijdBuffet(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.afbeelding);
            titel = itemView.findViewById(R.id.titel);
            datum = itemView.findViewById(R.id.datum);
            stad =  itemView.findViewById(R.id.Stad);
            prijs = itemView.findViewById(R.id.prijs);
            itemView.setOnClickListener(this);
        }

        public void setMaaltijd(Maaltijd maaltijd){
            mMaaltijd = maaltijd;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, detailPagina.class);
            intent.putExtra(oke, (Parcelable) mMaaltijd);
            mContext.startActivity(intent);
        }
    }
}
