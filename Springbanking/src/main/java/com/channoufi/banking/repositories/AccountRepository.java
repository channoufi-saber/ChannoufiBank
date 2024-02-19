/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.repositories;

import com.channoufi.banking.models.Account;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author channoufisaber
 */
public interface AccountRepository extends JpaRepository<Account, Integer>{
    Optional<Account> findByIban(String iban);
    Optional<Account> findByUserId(Integer id);
}
