package com.example.weatherappfromscratch.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseList {
    @SerializedName("response")

    private List<Periods> responseList;

    public ResponseList(List<Periods> response) {
        this.responseList = response;
    }

    public List<Periods> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Periods> responseList) {
        this.responseList = responseList;
    }
}
