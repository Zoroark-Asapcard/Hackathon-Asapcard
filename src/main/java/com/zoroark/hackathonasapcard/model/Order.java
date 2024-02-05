/*package com.zoroark.hackathonasapcard.model;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "tb_costumer")
public class Order {
	
	@Id
	@Column(columnDefinition = "varchar(36)")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	private String orderName;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	*/