package com.example.antrian.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Result_wait_done implements Parcelable {
    String response , message , wait , done;

    public Result_wait_done(String response, String message, String wait, String done) {
        this.response = response;
        this.message = message;
        this.wait = wait;
        this.done = done;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWait() {
        return wait;
    }

    public void setWait(String wait) {
        this.wait = wait;
    }

    public String getDone() {
        return done;
    }

    public void setDone(String done) {
        this.done = done;
    }

    protected Result_wait_done(Parcel in) {
        this.response = in.readString();
        this.message = in.readString();
        this.wait = in.readString();
        this.done = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(response);
        dest.writeString(message);
        dest.writeString(wait);
        dest.writeString(done);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result_wait_done> CREATOR = new Creator<Result_wait_done>() {
        @Override
        public Result_wait_done createFromParcel(Parcel in) {
            return new Result_wait_done(in);
        }

        @Override
        public Result_wait_done[] newArray(int size) {
            return new Result_wait_done[size];
        }
    };
}
