
package com.example.account.route;

import com.example.account.model.Customer;
import com.example.account.record.CustomerRecord;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegistrationRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        restConfiguration().
                apiContextRouteId("swagger")
                .contextPath("/contas/v1")
                .component("servlet")
                .host("localhost")
                .port(8080)
                .scheme("http");


        rest().path("/registration")
                .post()
                .id("createCustomer")
                .bindingMode(RestBindingMode.auto)
                .skipBindingOnErrorCode(true)
                .type(CustomerRecord.class)
                .consumes("application/json")
                .produces("application/json")
                .to("direct:registration");

        from("direct:registration")
                .log("Received customer: ${body}")
                .process(exchange -> {
                    Customer customer = exchange.getIn().getBody(Customer.class);
                    // Process customer data here
                    System.out.println("Customer received: " + customer);
                })
                .setBody(simple("Customer ${body.name} processed successfully"))
                .end();

    }
}

