package com.example.exchangenew.models;

import com.example.exchangenew.jsonoperate.GetJsonOperate;

import java.io.IOException;

public class ExchangeModel {

    private double valueOfCurrency;
    private double exchangeRate;
    private String nameOfCurrency;


    public ExchangeModel(double valueOfCurrency) {
        this.valueOfCurrency = valueOfCurrency;
    }

    public ExchangeModel(double valueOfCurrency, double exchangeRate, String nameOfCurrency) {
        this.valueOfCurrency = valueOfCurrency;
        this.exchangeRate = exchangeRate;
        this.nameOfCurrency = nameOfCurrency;
    }

    public double getValueOfCurrency() {
        return valueOfCurrency;
    }

    public void setValueOfCurrency(double valueOfCurrency) {
        this.valueOfCurrency = valueOfCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getNameOfCurrency() {
        return nameOfCurrency;
    }

    public void setNameOfCurrency(String nameOfCurrency) {
        this.nameOfCurrency = nameOfCurrency;
    }

    public double exchangeResults() throws IOException {
        double results = 0;

        GetJsonOperate getJsonOperate = new GetJsonOperate();
        getJsonOperate.getJsonData();

        results = this.valueOfCurrency * getJsonOperate.getExchangeRateFromJson();

        return results;
    }


}
