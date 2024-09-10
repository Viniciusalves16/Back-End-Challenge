package com.example.account.repository;

import com.example.account.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrasnferRepository extends JpaRepository<Transfer, Long> {
}
