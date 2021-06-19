package com.arsan.expense.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Double amount;
	private String note;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date transactionDate;
	
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

	public Transaction(Integer id, Double amount, String note, Date transactionDate) {
		this.id = id;	
		this.amount = amount;
		this.note = note;
		this.transactionDate = transactionDate;
	}
	
	public Transaction(Double amount, String note, Date transactionDate) {
		this.amount = amount;
		this.note = note;
		this.transactionDate = transactionDate;
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

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
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
