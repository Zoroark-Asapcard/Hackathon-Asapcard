package com.zoroark.hackathonasapcard.model;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Installment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;

    @NotBlank(message = "The number of installments is mandatory.")
    @Column(length = 1000)
    private int installmentNumber;

    @NotBlank(message = "The value attribute is mandatory")
    @Column(length = 1000)
    private float value;

    @ManyToOne
    @JsonIgnoreProperties("installment")
    private Transaction transaction;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public int getInstallmentNumber() {
		return installmentNumber;
	}

	public void setInstallmentNumber() {
		this.installmentNumber;
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