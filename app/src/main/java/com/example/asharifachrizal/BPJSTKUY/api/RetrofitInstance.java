package com.example.asharifachrizal.BPJSTKUY.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private static Retrofit retrofit;
//    private static final String BASE_URL = "http://bpjstkuy.klinikginjal-mitrahusada.com/api/";
    private static final String BASE_URL = "http://bpjstkuy.klinikginjal-mitrahusada.com/api/";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
