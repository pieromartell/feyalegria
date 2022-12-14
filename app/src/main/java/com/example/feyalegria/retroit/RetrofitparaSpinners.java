package com.example.feyalegria.retroit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitparaSpinners {
    private static final String BASE_URL = "http://192.168.1.36:3000/";
    private static Retrofit retrofit = null;

    public static  Retrofit getConnection(){
        if (retrofit == null){
            retrofit =  new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
