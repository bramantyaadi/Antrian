package com.example.antrian.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

import io.reactivex.rxjava3.annotations.Nullable;

public class Result_rv implements Parcelable {

    private String code;

    @Nullable
    private ArrayList<Item_antrian> items;

    @Nullable
    private Item_antrian item;

    protected Result_rv(Parcel in) {
        this.code = in.readString();
        this.items = in.createTypedArrayList(Item_antrian.CREATOR);
        this.item = in.readParcelable(Item_antrian.class.getClassLoader());
    }

    public Result_rv(String code, @Nullable ArrayList<Item_antrian> items, @Nullable Item_antrian item) {
        this.code = code;
        this.items = items;
        this.item = item;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<Item_antrian> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item_antrian> items) {
        this.items = items;
    }

    @Nullable
    public Item_antrian getItem() {
        return item;
    }

    public void setItem(Item_antrian item) {
        this.item = item;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Result_rv> CREATOR = new Creator<Result_rv>() {
        @Override
        public Result_rv createFromParcel(Parcel in) {
            return new Result_rv(in);
        }

        @Override
        public Result_rv[] newArray(int size) {
            return new Result_rv[size];
        }
    };
}
