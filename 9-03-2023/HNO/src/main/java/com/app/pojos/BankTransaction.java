package com.app.pojos;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.app.custom_exception.ResourceNotFoundException;

@Entity
@Table(name = "bank_transaction")
public class BankTransaction extends BaseEntity {
//	transactionId;
//	anonymous_donor_id INT
//	donor_id INT
	@ManyToOne
	@JoinColumn(name = "donor_id")
	private Donor donor;
//	employee_id INT
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
//	vendor_id INT
	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;

	@Column
	@CreationTimestamp
	private LocalDateTime createdOn;
	private double amountReceived;
	private double amountSend;
	private double balance;
	// ^6(?!52[12])(?:011|5[0-9][0-9])[0-9]{12}$
	private String cardNumber;

	public BankTransaction(Donor donor, Employee employee, Vendor vendor, LocalDateTime createdOn,
			double amountReceived, double amountSend, double balance, String cardNumber) {
		super();
		this.donor = donor;
		this.employee = employee;
		this.vendor = vendor;
		this.createdOn = createdOn;
		this.amountReceived = amountReceived;
		this.amountSend = amountSend;
		this.balance = balance;
		this.cardNumber = cardNumber;
	}

//	public BankTransaction(Donor donor, double amountReceived) {
//		super();
//		this.donor = donor;
//		this.amountReceived = amountReceived;
//	}
	
	

	public BankTransaction(double amountReceived, String cardNumber) {
		super();
		this.amountReceived = amountReceived;
		this.cardNumber = cardNumber;
	}

	public BankTransaction(Donor donor, double amountReceived, String cardNumber) {
	super();
	this.donor = donor;
	this.amountReceived = amountReceived;
	this.cardNumber = cardNumber;
}

	public BankTransaction(double balance) {
		super();
		this.balance = balance;
	}

	public BankTransaction(LocalDateTime createdOn) {
		super();
		this.createdOn = createdOn;
	}

	// deposit
	public void deposit(double amount) {
		this.balance += amount;
	}

	// withdraw
	public void withdraw(double amount) {
		System.out.println("inside withdraw balance = " + this.balance + "Amount = " + amount);
		if (this.balance > amount) {
			this.balance -= amount;
		} else {
			throw new ResourceNotFoundException("Insufficient balance");
		}
	}

	public BankTransaction() {
		super();
	}

	public Donor getDonor() {
		return donor;
	}

	public void setDonor(Donor donor) {
		this.donor = donor;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public double getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(double amountReceived) {
		this.amountReceived = amountReceived;
	}

	public double getAmountSend() {
		return amountSend;
	}

	public void setAmountSend(double amountSend) {
		this.amountSend = amountSend;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		return "BankTransaction [createdOn=" + createdOn + ", amountReceived=" + amountReceived + ", amountSend="
				+ amountSend + ", balance=" + balance + ", cardNumber=" + cardNumber + "]";
	}

}
