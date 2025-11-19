package com.my.apache.camel.routes.activemq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class ActiveMQProducerRouter extends RouteBuilder {


    @Override
    public void configure() throws Exception {
        //timer
//        from("timer:activemq-timer?period=20000")
//                .log("Inside ActiveMQSenderRouter")
//                .transform().constant("Hello from ActiveMQ!")
//                .log("Sending message: ${body}")
//                //queue listener (timer)
//                .log("Sending message to ActiveMQ queue")
//                .to("activemq:my-activemq-queue");
        //transformation
        //database (log)


//        from("file:files/json-to-queue")
//                .log("Inside ActiveMQSenderRouter")
//                .log("Sending json: ${body}")
//                .to("activemq:my-activemq-queue");


        from("file:files/xml-to-queue")
                .log("Inside ActiveMQSenderRouter")
                .log("Sending xml: ${body}")
                .to("activemq:my-activemq-queue-xml");



    }
}
