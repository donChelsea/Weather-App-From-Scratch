package com.example.weatherappfromscratch.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "https://api.aerisapi.com/";
    private Retrofit instance;

    //https://api.aerisapi.com/forecasts/newyork,%20ny?&format=json&filter=day&limit=7&client_id=Xrojwf0CVEM7GcVysgEbl&client_secret=TG1izYqy2iHHHVYQt2HZiKvGZF3QRHD1xs85RdZJ

    public RetrofitSingleton() {}

    public Retrofit getInstance() {
        if (instance == null) {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return instance;
    }
}
