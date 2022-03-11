package com.example.kookpagin.Domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Locatie implements Parcelable {
    private String StraatHuisNr;
    private String postCode;
    private String plaats;

    protected Locatie(Parcel in) {
        StraatHuisNr = in.readString();
        postCode = in.readString();
        plaats = in.readString();
    }

    public Locatie(String straatHuisNr, String postcode, String plaats) {
        this.StraatHuisNr = straatHuisNr;
        this.postCode = postcode;
        this.plaats = plaats;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(StraatHuisNr);
        dest.writeString(postCode);
        dest.writeString(plaats);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Locatie> CREATOR = new Creator<Locatie>() {
        @Override
        public Locatie createFromParcel(Parcel in) {
            return new Locatie(in);
        }

        @Override
        public Locatie[] newArray(int size) {
            return new Locatie[size];
        }
    };

    public String getStraatHuisNr() {
        return StraatHuisNr;
    }

    public void setStraatHuisNr(String straatHuisNr) {
        StraatHuisNr = straatHuisNr;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(String plaats) {
        this.plaats = plaats;
    }
}
