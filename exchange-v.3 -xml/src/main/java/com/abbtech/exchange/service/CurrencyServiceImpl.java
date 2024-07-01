package com.abbtech.exchange.service;

import com.abbtech.exchange.feignclient.ForexRateApiClient;
import com.abbtech.exchange.model.ExchangeRate;
import com.abbtech.exchange.model.ForexRatesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CurrencyServiceImpl implements CurrencyService {

    private final ForexRateApiClient forexRateApiClient;

    @Value("${api.key}")
    private  String apiKey;

    @Override
    public List<ExchangeRate> calculateExchangeRates(String sourceCurrency, Double amount) {
        String baseCurrency = sourceCurrency.toUpperCase();
        ForexRatesResponse response = forexRateApiClient.getLatestRates(apiKey, baseCurrency);
        Map<String, Double> rates = response.getRates();

        List<ExchangeRate> exchangeRates = new ArrayList<>();

        rates.forEach((currency, rate) -> {
            Double exchangeValue = amount * rate;
            exchangeRates.add(new ExchangeRate(currency, exchangeValue));
        });

        return exchangeRates;
    }
}
