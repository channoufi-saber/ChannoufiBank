/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.services;

import java.util.List;

/**
 *
 * @author channoufisaber
 */
public interface AbstractService<T> {
    
    Integer save(T dto);

    List<T> findAll();

    T findById(Integer id);

    void delete(Integer id);
}
