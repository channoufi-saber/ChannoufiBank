package com.channoufi.banking.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.experimental.SuperBuilder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import jakarta.persistence.JoinColumn;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public  class Transaction extends AbstractEntity{
	


	

	private BigDecimal amount;

	@Enumerated(EnumType.STRING)
	private TransactionType type;

	private String destinationIban;

	

	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
}






