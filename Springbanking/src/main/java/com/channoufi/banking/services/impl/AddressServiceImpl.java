/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.channoufi.banking.services.impl;

import com.channoufi.banking.dto.AddressDto;
import com.channoufi.banking.models.Address;
import com.channoufi.banking.repositories.AddressRepository;
import com.channoufi.banking.services.AddressService;
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
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;
    private ObjectsValidator<AddressDto> validator;

    @Override
    public Integer save(AddressDto dto) {
        validator.validate(dto);
        Address address=AddressDto.toEntity(dto);
        return repository.save(address).getId();
    }

    @Override
    public List<AddressDto> findAll() {
        return repository.findAll().stream().map(AddressDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public AddressDto findById(Integer id) {
        return repository.findById(id).map(AddressDto::fromEntity).orElseThrow(() -> new EntityNotFoundException("No address found with ID :"+id));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
    
}
