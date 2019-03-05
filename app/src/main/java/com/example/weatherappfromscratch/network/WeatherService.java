package com.example.weatherappfromscratch.network;

import com.example.weatherappfromscratch.model.ResponseList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherService {
    @GET("forecasts/newyork, ny?&format=json&filter=day&limit=7&client_id=Xrojwf0CVEM7GcVysgEbl&client_secret=4U5n53YUKe7hdIBQdY6toMmCi2iIu2a2siNuIBJn")
    Call<ResponseList> getResponse();
}
