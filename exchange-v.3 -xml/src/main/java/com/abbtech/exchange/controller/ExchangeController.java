package com.abbtech.exchange.controller;

import com.abbtech.exchange.model.ExchangeRate;
import com.abbtech.exchange.service.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exchange")
@RequiredArgsConstructor
public class ExchangeController {

    private final CurrencyService currencyService;

    @GetMapping("/{sourceCurrency}/{amount}")
    public List<ExchangeRate> getExchangeRates(@PathVariable String sourceCurrency,
                                               @PathVariable Double amount) {
        return currencyService.calculateExchangeRates(sourceCurrency, amount);
    }
}
