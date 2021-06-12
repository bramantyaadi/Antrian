package com.example.antrian.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.Nullable;

public class Result_next_antrian implements Parcelable {

    String response , nomor_antrian , jam_dipanggil;

    public Result_next_antrian(String response, String nomor_antrian, String jam_dipanggil) {
        this.response = response;
        this.nomor_antrian = nomor_antrian;
        this.jam_dipanggil = jam_dipanggil;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getNomor_antrian() {
        return nomor_antrian;
    }

    public void setNomor_antrian(String nomor_antrian) {
        this.nomor_antrian = nomor_antrian;
    }

    public String getJam_dipanggil() {
        return jam_dipanggil;
    }

    public void setJam_dipanggil(String jam_dipanggil) {
        this.jam_dipanggil = jam_dipanggil;
    }

    protected Result_next_antrian(Parcel in) {
        this.response = in.readString();
        this.nomor_antrian = in.readString();
        this.jam_dipanggil = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(response);
        dest.writeString(nomor_antrian);
        dest.writeString(jam_dipanggil);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result_next_antrian> CREATOR = new Creator<Result_next_antrian>() {
        @Override
        public Result_next_antrian createFromParcel(Parcel in) {
            return new Result_next_antrian(in);
        }

        @Override
        public Result_next_antrian[] newArray(int size) {
            return new Result_next_antrian[size];
        }
    };
}
