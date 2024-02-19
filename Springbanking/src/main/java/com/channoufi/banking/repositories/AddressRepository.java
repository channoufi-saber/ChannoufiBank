/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.repositories;

import com.channoufi.banking.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author channoufisaber
 */
public interface AddressRepository extends JpaRepository<Address, Integer> {
    
}
