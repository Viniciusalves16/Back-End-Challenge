/*
package com.example.account.route;

import com.example.account.enumeration.RouteEnumeration;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RouteCustomerRegistration extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        restConfiguration().component("servlet").bindingMode(RestBindingMode.auto);
        rest().path("contas")
                .produces("application/json")
                .get("/cadastro")
                .to(RouteEnumeration.CADASTRO.getId());

    }
}
*/
