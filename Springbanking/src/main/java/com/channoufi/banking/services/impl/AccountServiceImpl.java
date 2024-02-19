/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.channoufi.banking.services.impl;

import com.channoufi.banking.dto.AccountDto;
import com.channoufi.banking.exceptions.OperationNonPermittedException;
import com.channoufi.banking.models.Account;
import com.channoufi.banking.repositories.AccountRepository;
import com.channoufi.banking.services.AccountService;
import com.channoufi.banking.validators.ObjectsValidator;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.springframework.stereotype.Service;

/**
 *
 * @author channoufisaber
 */
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;
    private final ObjectsValidator<AccountDto> validator;

    @Override
    public Integer save(AccountDto dto) {
        if (dto.getId() != null) {
            throw new OperationNonPermittedException(
                    "Account cannot be updated",
                    "save account",
                    "Account",
                    "Update not permitted"
            );
        }
        validator.validate(dto);
        Account account = AccountDto.toEntity(dto);
        account.setIban(generateRandomIban());
        return repository.save(account).getId();
    }

    @Override
    public List<AccountDto> findAll() {
        return repository.findAll()
                .stream().map(AccountDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public AccountDto findById(Integer id) {
        return repository.findById(id).map(AccountDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No account was found with the ID : " + id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    private String generateRandomIban() {
        String iban = Iban.random(CountryCode.DE).toFormattedString();
        boolean ibanExists = repository.findByIban(iban).isPresent();
        if (ibanExists) {
            generateRandomIban();
        }

        return iban;
    }
}
