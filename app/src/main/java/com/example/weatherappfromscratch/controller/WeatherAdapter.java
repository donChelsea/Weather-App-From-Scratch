package com.example.weatherappfromscratch.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.weatherappfromscratch.R;
import com.example.weatherappfromscratch.model.Weather;
import com.example.weatherappfromscratch.view.WeatherViewHolder;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherViewHolder> {
    private List<Weather> weatherList;
    private List<Integer> weatherIcons;

    public WeatherAdapter(List<Weather> weatherList, List<Integer> weatherIcons) {
        this.weatherList = weatherList;
        this.weatherIcons = weatherIcons;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new WeatherViewHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.weather_list_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder weatherViewHolder, int i) {
        weatherViewHolder.onBind(weatherList.get(i), weatherIcons.get(i));
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }
}
