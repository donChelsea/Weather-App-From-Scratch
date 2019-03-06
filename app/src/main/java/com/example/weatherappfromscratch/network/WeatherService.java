package com.example.weatherappfromscratch.network;

import com.example.weatherappfromscratch.model.ResponseList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("forecasts/newyork, ny?&format=json&filter=day&limit=7&client_id={clientId}&client_secret={secretKey}")
    Call<ResponseList> getResponse(@Query("clientId") String clientId,
                                   @Query("secretKey") String secretKey);
}
