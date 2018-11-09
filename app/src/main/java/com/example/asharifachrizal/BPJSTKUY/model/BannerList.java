package com.example.asharifachrizal.BPJSTKUY.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class BannerList {
    @SerializedName("data")
    private ArrayList<Banner> bannerList;

    public ArrayList<Banner> getBannerList() {
        return bannerList;
    }

    public void setBannerList(ArrayList<Banner> bannerList) {
        this.bannerList = bannerList;
    }
}
