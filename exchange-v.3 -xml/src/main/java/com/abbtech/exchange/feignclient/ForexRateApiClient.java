package com.abbtech.exchange.feignclient;

import com.abbtech.exchange.model.ForexRatesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "forexRateApiClient", url = "https://api.forexrateapi.com/v1")
public interface ForexRateApiClient {

    @GetMapping("/latest")
    ForexRatesResponse getLatestRates(@RequestParam("api_key") String apiKey,
                                      @RequestParam("base") String baseCurrency);
}
