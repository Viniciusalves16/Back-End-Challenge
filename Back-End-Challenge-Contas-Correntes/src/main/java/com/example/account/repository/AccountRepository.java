package com.example.account.repository;

import com.example.account.model.Account;
import com.example.account.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

        @Query("SELECT con FROM Contas con WHERE con.id = :id AND con.accountNumber = :accountNumber")
        Optional<Account> findByIdAndAccountNumber(@Param("id") Long id, @Param("accountNumber") Long accountNumber);


}



