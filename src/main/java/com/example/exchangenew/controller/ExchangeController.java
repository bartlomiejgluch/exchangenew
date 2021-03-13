package com.example.exchangenew.controller;


import com.example.exchangenew.models.ExchangeModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class ExchangeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("view", "views/exchangeform");
        return "base-layout";
    }

    @PostMapping("/")
    public String index(
            @RequestParam String valueOfCurrency,
            Model model
    ) throws IOException {
        double valueOfCurrencyNumber;

        try {
            valueOfCurrencyNumber = Double.parseDouble(valueOfCurrency);
        } catch (NumberFormatException ex) {
            valueOfCurrencyNumber = 0;
        }

        ExchangeModel exchangeModel = new ExchangeModel(valueOfCurrencyNumber);

        double result = exchangeModel.exchangeResults();
double exchangeRate = exchangeModel.getExchangeRate();

        model.addAttribute("valueOfCurrency", valueOfCurrency);
        model.addAttribute("result", result);
        model.addAttribute("exchangeRate", exchangeRate);
        model.addAttribute("view", "views/exchangeform");

        return "base-layout";
    }
}