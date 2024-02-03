package com.zoroark.hackathonasapcard.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

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

@Entity
@Table(name = "tb_installment")

public class Installment {

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

	@UpdateTimestamp
	private LocalDateTime data;
	
	//*@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.REMOVE)
	 //*@JsonIgnoreProperties("transaction")	
	//*private List<Transaction> transaction; //*AGUARDANDO MODEL TRANSACTION 

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

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
}

