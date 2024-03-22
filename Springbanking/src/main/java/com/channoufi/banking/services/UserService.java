/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.channoufi.banking.services;

import com.channoufi.banking.dto.AuthenticationRequest;
import com.channoufi.banking.dto.AuthenticationResponse;
import com.channoufi.banking.dto.LightUserDto;
import com.channoufi.banking.dto.UserDto;

/**
 *
 * @author channoufisaber
 */
public interface UserService extends AbstractService<UserDto> {

    Integer validateAccount(Integer id);

    Integer invalidateAccount(Integer id);

    AuthenticationResponse register(UserDto user);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    Integer update(LightUserDto userDto);
}
