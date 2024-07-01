package com.abbtech.exchange.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForexRatesResponse {

    @JsonProperty("base")
    private String baseCurrency;

    @JsonProperty("rates")
    private Map<String, Double> rates;
}
