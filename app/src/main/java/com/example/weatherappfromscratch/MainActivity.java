package com.example.weatherappfromscratch;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.weatherappfromscratch.controller.WeatherAdapter;
import com.example.weatherappfromscratch.model.Periods;
import com.example.weatherappfromscratch.model.Weather;
import com.example.weatherappfromscratch.network.RetrofitSingleton;
import com.example.weatherappfromscratch.network.WeatherService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    Button button;
    Disposable retrofit;
    List<Integer> weatherIcons = new ArrayList<>(Arrays.asList(R.drawable.blizzard, R.drawable.blowingsnow, R.drawable.clear, R.drawable.drizzle, R.drawable.fair, R.drawable.flurriesw, R.drawable.hazy));

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);

        retrofit = new RetrofitSingleton().getInstance()
                .create(WeatherService.class)
                .getResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseList -> {
                    List<Periods> periods = responseList.getResponseList();
                    List<Weather> weathers = periods.get(0).getPeriods();
                    recyclerView.setAdapter(new WeatherAdapter(weathers, weatherIcons));
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }, throwable -> Log.d(TAG, "onFailure: ---" + throwable.getMessage())
                );
    }
}
