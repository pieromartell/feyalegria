package com.example.feyalegria.retroit;

import com.example.feyalegria.api.AndroidapiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static final String BASE_URL = "http://192.168.1.36:3000/";
    private static Retrofit retrofit = null;

    public static AndroidapiService getRetrofitCliente() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(AndroidapiService.class);
    }
}
