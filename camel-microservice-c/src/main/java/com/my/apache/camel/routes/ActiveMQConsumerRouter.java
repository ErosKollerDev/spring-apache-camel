package com.my.apache.camel.routes;

import com.my.apache.camel.CurrencyExchange;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class ActiveMQConsumerRouter extends RouteBuilder {

    private final CurrencyExchangeProcess currencyExchangeProcess;
    private final CurrencyExchangeTransform currencyExchangeTransform;

    @Override
    public void configure() throws Exception {
//        from("activemq:my-activemq-queue")
//                .unmarshal()
//                .json(JsonLibrary.Jackson, CurrencyExchange.class)
//                .bean(currencyExchangeProcess, "process")
//                .bean(currencyExchangeTransform, "transform")
//                .log("${body}");


        from("activemq:my-activemq-queue-xml")
                .unmarshal()
                .jacksonXml(CurrencyExchange.class)
//                .bean(currencyExchangeProcess, "process")
//                .bean(currencyExchangeTransform, "transform")
                .log("${body}")
                .to("log:activemq-consumer-log?level=INFO&showAll=true&multiline=true");


    }
}



