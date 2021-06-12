package com.example.antrian.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Result_next_ticket implements Parcelable {

    private String status , nomor_antrian , time;

    public Result_next_ticket(String status, String nomor_antrian, String time) {
        this.status = status;
        this.nomor_antrian = nomor_antrian;
        this.time = time;
    }

    protected Result_next_ticket(Parcel in) {
        this.status = in.readString();
        this.nomor_antrian = in.readString();
        this.time = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeString(this.nomor_antrian);
        dest.writeString(this.time);
    }

    public String nomor(){
        return nomor_antrian;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNomor_antrian() {
        return nomor_antrian;
    }

    public void setNomor_antrian(String nomor_antrian) {
        this.nomor_antrian = nomor_antrian;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result_next_ticket> CREATOR = new Creator<Result_next_ticket>() {
        @Override
        public Result_next_ticket createFromParcel(Parcel in) {
            return new Result_next_ticket(in);
        }

        @Override
        public Result_next_ticket[] newArray(int size) {
            return new Result_next_ticket[size];
        }
    };
}
