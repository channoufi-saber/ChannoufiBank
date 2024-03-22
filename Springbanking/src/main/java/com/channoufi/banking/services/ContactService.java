/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.services;

import com.channoufi.banking.dto.ContactDto;
import com.channoufi.banking.models.Contact;
import java.util.List;

/**
 *
 * @author channoufisaber
 */
public interface ContactService extends AbstractService<ContactDto> {

  List<ContactDto> findAllByUserId(Integer userId);
}