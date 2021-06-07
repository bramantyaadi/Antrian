package com.example.antrian.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Item_antrian implements Parcelable {
    private String nomor_antrian , jam_dibuat , jam_dipanggil;

    public Item_antrian(String nomor_antrian, String jam_dibuat, String jam_dipanggil) {
        this.nomor_antrian = nomor_antrian;
        this.jam_dibuat = jam_dibuat;
        this.jam_dipanggil = jam_dipanggil;
    }

    public String getNomor_antrian() {
        return nomor_antrian;
    }

    public void setNomor_antrian(String nomor_antrian) {
        this.nomor_antrian = nomor_antrian;
    }

    public String getJam_dibuat() {
        return jam_dibuat;
    }

    public void setJam_dibuat(String jam_dibuat) {
        this.jam_dibuat = jam_dibuat;
    }

    public String getJam_dipanggil() {
        return jam_dipanggil;
    }

    public void setJam_dipanggil(String jam_dipanggil) {
        this.jam_dipanggil = jam_dipanggil;
    }

    protected Item_antrian(Parcel in) {
        this.nomor_antrian = in.readString();
        this.jam_dibuat = in.readString();
        this.jam_dipanggil = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nomor_antrian);
        dest.writeString(this.jam_dibuat);
        dest.writeString(this.jam_dipanggil);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Item_antrian> CREATOR = new Creator<Item_antrian>() {
        @Override
        public Item_antrian createFromParcel(Parcel in) {
            return new Item_antrian(in);
        }

        @Override
        public Item_antrian[] newArray(int size) {
            return new Item_antrian[size];
        }
    };
}
