package com.my.apache.camel.routes.activemq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
//@Component
public class KafkaProducerRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        from("file:files/json-to-kafka-queue")
                .log("Inside ActiveMQSenderRouter")
                .log("Sending json: ${body}")
                .to("kafka:my-kafka-topic?brokers=localhost:9092");



    }
}
