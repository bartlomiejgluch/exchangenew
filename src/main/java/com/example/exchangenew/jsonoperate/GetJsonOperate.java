package com.example.exchangenew.jsonoperate;


import com.example.exchangenew.dto.JsonDto;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GetJsonOperate {

    private String nameOfCurrencyFromJson;
    private double exchangeRateFromJson;

    public String getNameOfCurrencyFromJson() {
        return nameOfCurrencyFromJson;
    }

    public void setNameOfCurrencyFromJson(String nameOfCurrencyFromJson) {
        this.nameOfCurrencyFromJson = nameOfCurrencyFromJson;
    }

    public double getExchangeRateFromJson() {
        return exchangeRateFromJson;
    }

    public void setExchangeRateFromJson(double exchangeRateFromJson) {
        this.exchangeRateFromJson = exchangeRateFromJson;
    }

    public void getJsonData() throws IOException {


        String sURL = "http://api.nbp.pl/api/exchangerates/rates/a/gbp/?format=json";

        URL url = new URL(sURL);
        URLConnection request = url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

        Gson gson = new Gson();

        JsonDto jsonDto = gson.fromJson(root.toString(), JsonDto.class);

        this.nameOfCurrencyFromJson = jsonDto.currency;
        this.exchangeRateFromJson = jsonDto.rates[0].mid;

    }
}
