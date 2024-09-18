package com.example.account.repository;

import com.example.account.model.Transfer;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query(value = "SELECT EXISTS (SELECT 1 FROM CONTAS c WHERE c.ACCOUNT_NUMBER IN (?, ?) AND UPPER(c.STATUS) = 'ACTIVE')", nativeQuery = true)
    public boolean accountExistsAndActive(@Param("accountOrigin") Long accountOrigin, @Param("accountDestination") Long accountDestination);

    @Query(value = "SELECT c.BALANCE FROM CONTAS c WHERE c.ACCOUNT_NUMBER = ?", nativeQuery = true)
    BigDecimal searchBalance(@NotNull Long accountNumber);

    @Modifying
    @Query(value = "UPDATE CONTAS c SET c.BALANCE = ?2 WHERE c.ACCOUNT_NUMBER = ?1", nativeQuery = true)
    void updateBalance(@Param("accountNumber") Long accountNumber, @Param("newBalance") BigDecimal newBalance);



    }



