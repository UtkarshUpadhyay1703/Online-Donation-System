package com.app.dto.BankTransaction;

import com.app.pojos.Donor;

public class ReceivedDto {
	private double amountReceived;
	// @Pattern(regexp = "^6(?!52[12])(?:011|5[0-9][0-9])[0-9]{12}$", message =
	// "Please write right Rupay Thank you!!!")
	private String cardNumber;
	private Donor don;

	public ReceivedDto(double amountReceived, String cardNumber, Donor don) {
		super();
		this.amountReceived = amountReceived;
		this.cardNumber = cardNumber;
		this.don = don;
	}

	public ReceivedDto() {
		super();
	}

	public double getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(double amountReceived) {
		this.amountReceived = amountReceived;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Donor getDon() {
		return don;
	}

	public void setDon(Donor don) {
		this.don = don;
	}

	@Override
	public String toString() {
		return "ReceivedDto [amountReceived=" + amountReceived + ", cardNumber=" + cardNumber + ", don=" + don + "]";
	}

}
