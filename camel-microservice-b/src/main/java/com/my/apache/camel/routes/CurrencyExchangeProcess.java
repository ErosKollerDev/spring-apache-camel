package com.my.apache.camel.routes;

import com.my.apache.camel.CurrencyExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CurrencyExchangeProcess {

    public void process(CurrencyExchange currencyExchange) {
        System.out.println("Processing CurrencyExchange: " + currencyExchange);
        log.warn("\nProcessing CurrencyExchange:\n {}", currencyExchange);
    }

}
