package com.zoroark.hackathonasapcard.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_installment")

public class Installment {

	public Installment(UUID id, int installmentNumber, float value) {
		this.id = id;
		this.installmentNumber = installmentNumber;
		this.value = value;
		
	}

	public Installment() {	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "varchar(36)")
	private UUID id;

	@Column(length = 1000)
	@NotBlank(message = "The number of installments is mandatory.")
	private int installmentNumber;

	@Column(length = 1000)
	@NotBlank(message = "The value attribute is mandatory")
	private float value;
	
	@ManyToOne
	@JsonIgnoreProperties("installment")
	private Transaction transaction;
	
	public double setAmount(double installmentAmount) {
		return installmentAmount;
		
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber(int installmentNumber) {
		this.installmentNumber = installmentNumber;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}


	
}

