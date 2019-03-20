package com.example.weatherappfromscratch.model;

public class Weather {
    private String minTempF;
    private String maxTempF;
    private String minTempC;
    private String maxTempC;
    private String dateTimeISO;

    public Weather(String minTempF, String maxTempF, String maxTempC, String minTempC, String dateTimeISO) {
        this.minTempF = minTempF;
        this.maxTempF = maxTempF;
        this.maxTempC = maxTempC;
        this.minTempC = minTempC;
        this.dateTimeISO = dateTimeISO;
    }

    public String getMinTempF() {
        return minTempF;
    }

    public String getMaxTempF() {
        return maxTempF;
    }

    public String getDateTimeISO() {
        return dateTimeISO;
    }

    public String getMinTempC() {
        return minTempC;
    }

    public String getMaxTempC() {
        return maxTempC;
    }
}
