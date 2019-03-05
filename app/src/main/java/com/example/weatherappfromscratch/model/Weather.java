package com.example.weatherappfromscratch.model;

public class Weather {
    private String minTempF;
    private String maxTempF;
    private String minTempC;
    private String maxTempC;
    private String dateTimeISO;

    public Weather() {
    }

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

    public void setMaxTempC(String maxTempC) {
        this.maxTempC = maxTempC;
    }

    public void setMinTempC(String minTempC) {
        this.minTempC = minTempC;
    }

    public void setMinTempF(String minTempF) {
        this.minTempF = minTempF;
    }

    public void setMaxTempF(String maxTempF) {
        this.maxTempF = maxTempF;
    }

    public void setDateTimeISO(String dateTimeISO) {
        this.dateTimeISO = dateTimeISO;
    }
}
