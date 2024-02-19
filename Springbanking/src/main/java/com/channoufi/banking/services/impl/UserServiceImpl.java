/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.channoufi.banking.services.impl;

import com.channoufi.banking.dto.AccountDto;
import com.channoufi.banking.dto.UserDto;
import com.channoufi.banking.models.User;
import com.channoufi.banking.repositories.UserRepository;
import com.channoufi.banking.services.AccountService;
import com.channoufi.banking.services.UserService;
import com.channoufi.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author channoufisaber
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final AccountService accountService;
    private final ObjectsValidator<UserDto> validator;

    @Override
    public Integer save(UserDto dto) {
        validator.validate(dto);
        User user = UserDto.toEntity(dto);
        return repository.save(user).getId();
    }

    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(UserDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Integer id) {
        return repository.findById(id).map(UserDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No user was found with the provided ID :" + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Integer validateAccount(Integer id) {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No user was found for user account validation"));
        user.setActive(true);

        AccountDto account = AccountDto.builder().user(UserDto.fromEntity(user)).build();
        accountService.save(account);
        repository.save(user);
        return user.getId();
    }

    @Override
    public Integer invalidateAccount(Integer id) {
        User user = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("No user was found for user account validation"));
        user.setActive(false);

        repository.save(user);
        return user.getId();
    }

}
