package com.my.apache.camel.routes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class MyFileRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:files/input")
                .log("${body}")
                .log("Processing file: ${header.CamelFileName}")
                .log("Processing file: ${header.CamelFileAbsolutePath}")
                .to("file:files/output");
    }
}
