package com.channoufi.banking.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;



@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends AbstractEntity {

  private String street;

  private Integer houseNumber;

  private Integer zipCode;

  private String city;

  private String county;

  @OneToOne
  @JoinColumn(name = "id_user")
  private User user;
}