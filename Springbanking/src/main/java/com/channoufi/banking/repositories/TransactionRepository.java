/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.repositories;

import com.channoufi.banking.dto.TransactionSumDetails;
import com.channoufi.banking.models.Transaction;
import com.channoufi.banking.models.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author channoufisaber
 */
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

  List<Transaction> findAllByUserId(Integer userId);

  @Query("select sum(t.amount) from Transaction t where t.user.id = :userId")
  BigDecimal findAccountBalance(@Param("userId") Integer userId);

  @Query("select max(abs(t.amount)) as amount from Transaction t where t.user.id = :userId and t.type = :transactionType")
  BigDecimal findHighestAmountByTransactionType(Integer userId, TransactionType transactionType);

  @Query("select t.transactionDate as transactionDate, sum(t.amount) as amount from Transaction t where t.user.id = :userId and t.createdDate "
      + "between :start and :end "
      + "group by t.transactionDate")
  List<TransactionSumDetails> findSumTransactionsByDate(LocalDateTime start, LocalDateTime end, Integer userId);
}