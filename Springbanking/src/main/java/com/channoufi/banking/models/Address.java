package com.channoufi.banking.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;



@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public  class Address extends AbstractEntity{
	


 private String street;

  private Integer houseNumber;

  private Integer zipCode;

  private String city;

  private String county;

  @OneToOne
  @JoinColumn(name="id_user")
  private User user;

}