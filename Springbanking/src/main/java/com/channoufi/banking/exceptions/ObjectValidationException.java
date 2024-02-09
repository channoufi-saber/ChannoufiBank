/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.channoufi.banking.exceptions;

import java.util.Set;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author channoufisaber
 */
@RequiredArgsConstructor
public class ObjectValidationException extends RuntimeException {
    
    @Getter
    private final Set<String> violations;

    @Getter
    private final String violationSource;
}
