package com.my.apache.camel.controller;


import com.my.apache.camel.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @GetMapping(value = "/from/{from}/to/{to}", produces = "application/json")
    public CurrencyExchange getCurrencyExchangeRate(@PathVariable String from, @PathVariable String to) {
        log.warn("Getting currency exchange rate from {} to {}", from, to);
        return new CurrencyExchange(10000L, from, to, BigDecimal.TEN,1D);
    }

}
