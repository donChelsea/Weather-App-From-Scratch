package com.example.weatherappfromscratch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Periods {
   @SerializedName("periods")

    private List<Weather> periods;

    public Periods(List<Weather> periods) {
        this.periods = periods;
    }

    public List<Weather> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Weather> periods) {
        this.periods = periods;
    }
}
