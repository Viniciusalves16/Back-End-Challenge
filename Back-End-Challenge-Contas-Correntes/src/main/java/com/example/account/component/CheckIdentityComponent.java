package com.example.account.component;

import com.example.account.model.Customer;
import com.example.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckIdentityComponent {

    @Autowired
    private CustomerRepository customerRepository;

    public Long verifyIdentity(String cpfCnpj) {
        Long tempDoc = customerRepository.existsByCpfCnpj(cpfCnpj);

        if (!tempDoc.equals(null)) {
            return tempDoc;
        }
        return null;

    }
}
