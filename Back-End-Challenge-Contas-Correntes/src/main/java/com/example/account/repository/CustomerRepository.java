package com.example.account.repository;

import com.example.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Object findBycpfCnpj(String cpfCnpj);

    Optional<Customer> findById(Double id);

    @Query(value = "SELECT id FROM Clientes WHERE cpf_Cnpj = :cpfCnpj", nativeQuery = true)
    Long existsByCpfCnpj(@Param("cpfCnpj") String cpfCnpj);
}
