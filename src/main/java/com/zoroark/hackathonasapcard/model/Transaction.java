package com.zoroark.hackathonasapcard.model;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "tb_transaction")
public class Transaction {
	
	public Transaction(UUID id, LocalDate transactionDate, Double amount) {
		this.id = id;
		this.transactionDate = transactionDate;
		this.amount = amount;
		//this.status = 'P';
	}

	public Transaction() {	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "varchar(36)")
    private UUID id;
	
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate transactionDate;
	
	@NotNull
	private Double amount;
	
	//@Column(columnDefinition = "char(1) default 'P' not null")
	//private char status; nivel_02

	
	@ManyToOne
	@JsonIgnoreProperties("Transaction")
	private Person person;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transaction", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("Transaction")
	private List<Installment> installment;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Installment> getInstallment() {
		return installment;
	}

	public void setInstallment(List<Installment> installment) {
		this.installment = installment;
	}

	/*public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	} */
	

}
