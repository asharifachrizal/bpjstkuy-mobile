package com.example.asharifachrizal.BPJSTKUY.api;

import com.example.asharifachrizal.BPJSTKUY.model.Auth;
import com.example.asharifachrizal.BPJSTKUY.model.BannerList;
import com.example.asharifachrizal.BPJSTKUY.model.NewsList;
import com.example.asharifachrizal.BPJSTKUY.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login")
    Call<User> auth(@Body Auth auth);

    @GET("details")
    Call<User> getUser(@Header("Authorization") String authHeader);

    @GET("news")
    Call<NewsList> getNews(@Header("Authorization") String authHeader);

    @GET("banners")
    Call<BannerList> getBanners(@Header("Authorization") String authHeader);
}
