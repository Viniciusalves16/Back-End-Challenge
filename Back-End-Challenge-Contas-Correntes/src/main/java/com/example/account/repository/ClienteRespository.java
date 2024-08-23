package com.example.account.repository;

import com.example.account.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRespository  extends JpaRepository<Cliente, Long> {
}
