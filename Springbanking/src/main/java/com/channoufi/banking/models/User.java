package com.channoufi.banking.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
@Table(name="_user")
public  class User extends AbstractEntity {
	
	


	private String firstname;

	private String lastname;

	private String email;

	private String password;

	private boolean active;

//	private Address address;

	@OneToMany(mappedBy="user")
	private List<Transaction> transactions;

	@OneToMany(mappedBy="user")
	private List<Contact> contacts;

	@OneToOne
	private Account account;

	@OneToOne
	private Address address;

	@OneToOne
	private Role role;
}
