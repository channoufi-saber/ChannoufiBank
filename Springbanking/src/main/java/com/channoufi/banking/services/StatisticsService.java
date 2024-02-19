/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.services;

import com.channoufi.banking.dto.TransactionSumDetails;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


/**
 *
 * @author channoufisaber
 */
public interface StatisticsService {
    List<TransactionSumDetails> findSumTractionsByDate(LocalDate startDate,LocalDate endDate,Integer userId);
    BigDecimal getAccountBalance(Integer userId);
    BigDecimal highestTransfer(Integer userId);
    BigDecimal highestDeposit(Integer userId);
}
