package com.example.asharifachrizal.BPJSTKUY.api;

import com.example.asharifachrizal.BPJSTKUY.model.BannerList;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("news")
    Call<NewsList> getNews();

    @GET("banners")
    Call<BannerList> getBanners();
}
