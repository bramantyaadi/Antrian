package com.example.antrian;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "userNew")
public class UserDataNew implements Parcelable {

    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "role")
    String role;

    public UserDataNew(String email, String name, String password, String role) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    protected UserDataNew(Parcel in) {
        this.email = in.readString();
        this.name = in.readString();
        this.password = in.readString();
        this.role = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(email);
        dest.writeString(name);
        dest.writeString(password);
        dest.writeString(role);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserDataNew> CREATOR = new Creator<UserDataNew>() {
        @Override
        public UserDataNew createFromParcel(Parcel in) {
            return new UserDataNew(in);
        }

        @Override
        public UserDataNew[] newArray(int size) {
            return new UserDataNew[size];
        }
    };

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
