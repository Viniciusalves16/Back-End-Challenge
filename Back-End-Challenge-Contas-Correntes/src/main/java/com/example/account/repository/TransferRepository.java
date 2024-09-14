package com.example.account.repository;

import com.example.account.model.Account;
import com.example.account.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query(value = "SELECT EXISTS (SELECT 1 FROM CONTAS c WHERE c.ACCOUNT_NUMBER IN (?, ?) AND UPPER(c.STATUS) = 'ACTIVE')", nativeQuery = true)
    public boolean accountExistsAndActive(@Param("accountOrigin") Long accountOrigin, @Param("accountDestination") Long accountDestination);

    @Query(value = "SELECT c.BALANCE FROM CONTAS c WHERE c.ACCOUNT_NUMBER = ?", nativeQuery = true)
    BigDecimal searchBalance(Long accountNumber);
}
