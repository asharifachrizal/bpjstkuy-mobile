package com.example.asharifachrizal.BPJSTKUY.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("nik")
    private String nik;
    @SerializedName("place_birth")
    private String place_birth;
    @SerializedName("dob")
    private String dob;
    @SerializedName("address")
    private String address;
    @SerializedName("path_dp")
    private String path_dp;
    @SerializedName("token")
    private String token;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getPlace_birth() {
        return place_birth;
    }

    public void setPlace_birth(String place_birth) {
        this.place_birth = place_birth;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPath_dp() {
        return path_dp;
    }

    public void setPath_dp(String path_dp) {
        this.path_dp = path_dp;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
