package com.channoufi.banking.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public  class Account extends AbstractEntity {
	
	

	private String iban;
	

	@OneToOne
	@JoinColumn(name="id_user")
	private User user;

}