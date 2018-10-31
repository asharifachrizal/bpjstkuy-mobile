package com.example.asharifachrizal.BPJSTKUY.api;

import com.example.asharifachrizal.BPJSTKUY.model.News;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("news")
    Call<NewsList> getNews();
}
