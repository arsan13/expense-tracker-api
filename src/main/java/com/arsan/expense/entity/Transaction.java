package com.arsan.expense.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double amount;
	private String note; 
	private Long transactionDate;
	private boolean remind;
	
	@JsonIgnore
	@JoinColumn()
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@JsonIgnore
	@JoinColumn()
	@ManyToOne(fetch = FetchType.LAZY)
	private Category category;

	public Transaction() {
	}

	public Transaction(Integer id, Double amount, String note, Long transactionDate, boolean remind) {
		this.id = id;
		this.amount = amount;
		this.note = note;
		this.transactionDate = transactionDate;
		this.remind = remind;
	}
	
	public Transaction(Double amount, String note, Long transactionDate, boolean remind) {
		this.amount = amount;
		this.note = note;
		this.transactionDate = transactionDate;
		this.remind = remind;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Long transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public boolean isRemind() {
		return remind;
	}

	public void setRemind(boolean remind) {
		this.remind = remind;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
