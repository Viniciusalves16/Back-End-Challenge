package com.example.account.route.Registration;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class CustomerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:registration")
                .process(Exchange -> System.out.println("cheguei ate aqui"))
                .log("Inicio do cadastro do cliente").end();
    }
}
