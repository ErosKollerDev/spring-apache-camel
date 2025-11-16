package com.my.apache.camel.routes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.MulticastProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Slf4j
//@Component
@RequiredArgsConstructor
public class MyFirstTimerRouter extends RouteBuilder {

    private final GetCurrentTimeBean getCurrentTimeBean;
    private final SimpleLoggingProcessingComponent simpleLoggingProcessingComponent;

    @Override
    public void configure() throws Exception {
        //queue listener (timer)
        //transformation
        //database (log)

        //Processing doesn't change the body of the message
        //Transformation changes the body of the message

        var date = LocalDateTime.now();
        from("timer:first-timer?period=10000") // I could be grabbing from a Queue and ...
                .log("Inside MyFirstTimerRouter")
//                .transform().constant("My Constant Message")
//                .transform().constant("Time now is: %s ".formatted(date.toString()))
//                .bean(GetCurrentTimeBean.class, "getCurrentTime")
                .log("Before: ${body}")
                .bean(getCurrentTimeBean)
                .bean(simpleLoggingProcessingComponent)
                .log("After: ${body}")
                .process(new MyProcessor())
                .to("log:first-timer-log?level=INFO&showAll=true&multiline=true"); // Sending to a Database
    }
}

@Component
class GetCurrentTimeBean {
    public String getCurrentTime() {
        return LocalDateTime.now().toString();
    }
}

@Slf4j
@Component( "simpleLoggingProcessingComponent")
class SimpleLoggingProcessingComponent {
    public void process(String message) {
        log.warn( "Processing message: {}", message);
    }
}

@Slf4j
class MyProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        log.warn("Processing message: {}", exchange.getMessage().getBody());
    }
}
