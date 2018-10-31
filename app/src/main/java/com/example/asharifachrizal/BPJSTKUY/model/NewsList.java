package com.example.asharifachrizal.BPJSTKUY.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NewsList {
    @SerializedName("data")
    private ArrayList<News> newsList;

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(ArrayList<News> newsList) {
        this.newsList = newsList;
    }
}
