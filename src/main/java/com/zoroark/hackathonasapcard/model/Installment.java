package com.zoroark.hackathonasapcard.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_installment")

public class Installment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 1000)
	@NotBlank(message = "The number of installments is mandatory.")
	private int installmentNumber;

	@Column(length = 1000)
	@NotBlank(message = "The value attribute is mandatory")
	private float value;

	@UpdateTimestamp
	private LocalDateTime data;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("transaction")	
	private List<Transaction> transaction;
	
}

