package com.example.antrian.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Result_last_call implements Parcelable {
    String response , nomor_antrian , jam_dibuat , jam_dipanggil;

    public Result_last_call(String response, String nomor_antrian, String jam_dibuat, String jam_dipanggil) {
        this.response = response;
        this.nomor_antrian = nomor_antrian;
        this.jam_dibuat = jam_dibuat;
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

    protected Result_last_call(Parcel in) {
        this.response = in.readString();
        this.jam_dibuat = in.readString();
        this.jam_dipanggil = in.readString();
        this.nomor_antrian = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(response);
        dest.writeString(jam_dibuat);
        dest.writeString(jam_dipanggil);
        dest.writeString(nomor_antrian);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result_last_call> CREATOR = new Creator<Result_last_call>() {
        @Override
        public Result_last_call createFromParcel(Parcel in) {
            return new Result_last_call(in);
        }

        @Override
        public Result_last_call[] newArray(int size) {
            return new Result_last_call[size];
        }
    };
}
