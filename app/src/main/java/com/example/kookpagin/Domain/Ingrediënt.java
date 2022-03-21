package com.example.kookpagin.Domain;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

public class Ingrediënt implements Parcelable {
    private String naam;
    private String afbeeldingURL;
    private boolean isAllergic;

    protected Ingrediënt(Parcel in) {
        naam = in.readString();
        this.afbeeldingURL = in.readString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            this.isAllergic = in.readBoolean();
        }
    }

    public static final Creator<Ingrediënt> CREATOR = new Creator<Ingrediënt>() {
        @Override
        public Ingrediënt createFromParcel(Parcel in) {
            return new Ingrediënt(in);
        }

        @Override
        public Ingrediënt[] newArray(int size) {
            return new Ingrediënt[size];
        }
    };

    public Ingrediënt(String naam, String afbeeldingUrl, boolean isAllergic) {
        this.naam = naam;
        this.afbeeldingURL = afbeeldingUrl;
        this.isAllergic = isAllergic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel des, int i) {
        des.writeString(naam);
        des.writeString(afbeeldingURL);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            des.writeBoolean(isAllergic);
        }
    }


    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getAfbeeldingURL() {
        return afbeeldingURL;
    }

    public void setAfbeeldingURL(String afbeeldingURL) {
        this.afbeeldingURL = afbeeldingURL;
    }

    public boolean isAllergic() {
        return isAllergic;
    }

    public void setAllergic(boolean allergic) {
        isAllergic = allergic;
    }

    public static Creator<Ingrediënt> getCREATOR() {
        return CREATOR;
    }
}
