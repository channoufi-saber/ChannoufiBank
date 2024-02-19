/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.repositories;

import com.channoufi.banking.dto.ContactDto;
import com.channoufi.banking.models.Contact;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author channoufisaber
 */
public interface ContactRepository extends JpaRepository<Contact, Integer> {
  List<Contact> findAllByUserId(Integer userId);
}
