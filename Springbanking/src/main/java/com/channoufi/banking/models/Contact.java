package com.channoufi.banking.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public  class Contact extends AbstractEntity {
	
	

	private String firstname;

  	private String lastname;

  	private String email;

  	private String iban;

  	@ManyToOne
  	@JoinColumn(name="id_user")
  	private User user;
}
