package com.example.account.component;

import com.example.account.model.Customer;
import com.example.account.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckIdentityComponent {

    @Autowired
    private CustomerRepository customerRepository;

    public boolean verifyIdentity(String cpfCnpj) {
        var tempDoc = customerRepository.existsByCpfCnpj(cpfCnpj);
        if (!tempDoc.isEmpty()) {
            return true;
        }
        return false;

    }
}
