/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.channoufi.banking.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 *
 * @author channoufisaber
 */
@RequiredArgsConstructor
@Getter
public class OperationNonPermittedException extends RuntimeException {

  private final String errorMsg;

  private final String operationId;

  private final String source;

  private final String dependency;

}
