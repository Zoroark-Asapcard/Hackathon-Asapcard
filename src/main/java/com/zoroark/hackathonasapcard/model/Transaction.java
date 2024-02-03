package com.zoroark.hackathonasapcard.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

public class Transaction {
	
	@Id // Primary Key
	@GeneratedValue(strategy= GenerationType.IDENTITY) // Auto_Increment
	private Long id;
	
	@Id
	@Column
	private Long personId;
	
	@NotNull
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate transactionDate;
	
	@NotNull
	@Column
	private Double amount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	} 
	

}
