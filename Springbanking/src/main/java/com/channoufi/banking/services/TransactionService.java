/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.services;

import com.channoufi.banking.dto.TransactionDto;
import com.channoufi.banking.models.Transaction;
import java.util.List;

/**
 *
 * @author channoufisaber
 */
public interface TransactionService extends AbstractService<TransactionDto> {

  List<TransactionDto> findAllByUserId(Integer userId);
}