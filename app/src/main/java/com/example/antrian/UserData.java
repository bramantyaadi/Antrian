package com.example.antrian;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class UserData implements Parcelable {
//    String email ,name , password;

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "password")
    String password;


    public UserData(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }


    protected UserData(Parcel in) {
        email = in.readString();
        name = in.readString();
        password = in.readString();
    }

    public static final Creator<UserData> CREATOR = new Creator<UserData>() {
        @Override
        public UserData createFromParcel(Parcel in) {
            return new UserData(in);
        }

        @Override
        public UserData[] newArray(int size) {
            return new UserData[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(name);
        dest.writeString(password);
    }
}
