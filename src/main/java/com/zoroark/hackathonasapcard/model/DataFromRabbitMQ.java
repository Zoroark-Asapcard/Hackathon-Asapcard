package com.zoroark.hackathonasapcard.model;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import com.zoroark.hackathonasapcard.service.InstallmentService;
import com.zoroark.hackathonasapcard.service.TransactionService;

public class DataFromRabbitMQ {
	
	@Autowired
    private TransactionService transactionService; // Substitua pelos seus serviços reais
	private InstallmentService installmentService; // Substitua pelos seus serviços reais

    private String transactionDate;
    private double amount;
    private int installmentNumber;
    private double installmentAmount;

    // Construtores
    public DataFromRabbitMQ(String transactionDate, double amount, int installmentNumber, double installmentAmount) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.installmentNumber = installmentNumber;
        this.installmentAmount = installmentAmount;
    }

    public DataFromRabbitMQ() {
    }

    // Getter e Setter para transactionDate
    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Getter e Setter para amount
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Getter e Setter para installmentNumber
    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    // Getter e Setter para installmentAmount
    public double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    // Método para fazer o parsing da String para LocalDate
    
    public LocalDate parseTransactionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(transactionDate, formatter);
    }

	public TransactionService getTransactionService() {
		return transactionService;
	}

	public void setTransactionService(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	public InstallmentService getInstallmentService() {
		return installmentService;
	}

	public void setInstallmentService(InstallmentService installmentService) {
		this.installmentService = installmentService;
	}
}
