package com.channoufi.banking.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;




@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Role extends AbstractEntity {
	
	

	private String name;

	@OneToOne
  	@JoinColumn(name="id_user")
  	private User user;

}
