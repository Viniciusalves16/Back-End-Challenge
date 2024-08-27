package com.example.account.component;

import com.example.account.model.Cliente;
import com.example.account.repository.CnpjGroup;
import com.example.account.repository.CpfGroup;
import jakarta.validation.ValidationException;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidacaoDocumento implements DefaultGroupSequenceProvider<Cliente> {

    @Override
    public List<Class<?>> getValidationGroups(Cliente cliente) {
        List<Class<?>> groups = new ArrayList<>();
        groups.add(Cliente.class);

        if (cliente != null) {
            if ("PF".equalsIgnoreCase(cliente.getTipo())) {
                groups.add(CpfGroup.class);
            } else if ("PJ".equalsIgnoreCase(cliente.getTipo())) {
                groups.add(CnpjGroup.class);
            }
        }
        return groups;
    }


}
