package com.example.account.component;

import com.example.account.model.Customer;
import com.example.account.repository.CnpjGroup;
import com.example.account.repository.CpfGroup;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidateDocumentTypeComponent implements DefaultGroupSequenceProvider<Customer> {

    @Override
    public List<Class<?>> getValidationGroups(Customer customer) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(Customer.class);

        if (customer != null) {
            if ("PF".equalsIgnoreCase(customer.getType())) {
                groups.add(CpfGroup.class);
            } else if ("PJ".equalsIgnoreCase(customer.getType())) {
                groups.add(CnpjGroup.class);
            }
        }
        return groups;
    }


}
