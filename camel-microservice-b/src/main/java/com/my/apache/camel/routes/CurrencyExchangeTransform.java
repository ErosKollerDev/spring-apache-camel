package com.my.apache.camel.routes;

import com.my.apache.camel.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CurrencyExchangeTransform {

    public CurrencyExchange transform(CurrencyExchange currencyExchange) {
        System.out.println("Processing CurrencyExchange: " + currencyExchange);
        currencyExchange.setAmount(currencyExchange.getAmount() * 2);
        log.warn("\nProcessing CurrencyExchange:\n {}", currencyExchange);
        return currencyExchange;
    }

}
