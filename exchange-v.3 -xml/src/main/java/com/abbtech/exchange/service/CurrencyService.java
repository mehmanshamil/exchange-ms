package com.abbtech.exchange.service;

import com.abbtech.exchange.model.ExchangeRate;
import java.util.List;

public interface CurrencyService {
    List<ExchangeRate> calculateExchangeRates(String sourceCurrency, Double amount);
}
