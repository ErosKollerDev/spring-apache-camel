package com.my.apache.camel.routes;

import com.my.apache.camel.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
//@Component
public class KafkaConsumerRouter extends RouteBuilder {

    private final CurrencyExchangeProcess currencyExchangeProcess;
    private final CurrencyExchangeTransform currencyExchangeTransform;

    @Override
    public void configure() throws Exception {


        from("kafka:my-kafka-topic?brokers=localhost:9092")
                .log("${body}")
                .to("log:kafka-consumer-log?level=INFO&showAll=true&multiline=true");


    }
}



