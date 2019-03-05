package com.example.weatherappfromscratch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.weatherappfromscratch.controller.WeatherAdapter;
import com.example.weatherappfromscratch.model.Periods;
import com.example.weatherappfromscratch.model.ResponseList;
import com.example.weatherappfromscratch.model.Weather;
import com.example.weatherappfromscratch.network.RetrofitSingleton;
import com.example.weatherappfromscratch.network.WeatherService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    Retrofit retrofit;
    List<Integer> weatherIcons = new ArrayList<>(Arrays.asList(R.drawable.blizzard, R.drawable.blowingsnow, R.drawable.clear, R.drawable.drizzle, R.drawable.fair, R.drawable.flurriesw, R.drawable.hazy));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        retrofit = new RetrofitSingleton().getInstance();
        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<ResponseList> responseListCall = weatherService.getResponse();
        responseListCall.enqueue(new Callback<ResponseList>() {
            @Override
            public void onResponse(Call<ResponseList> call, Response<ResponseList> response) {
                List<Periods> periods = response.body().getResponseList();
                List<Weather> weathers = periods.get(0).getPeriods();
                recyclerView.setAdapter(new WeatherAdapter(weathers, weatherIcons));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<ResponseList> call, Throwable t) {
                Log.d(TAG, "onFailure: ---" + t.getMessage());
            }
        });
    }
}
