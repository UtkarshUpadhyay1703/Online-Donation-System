package com.app.dto.BankTransaction;

public class DonorDto {
	private double amountReceived;
	private String cardNumber;

	public DonorDto(double amountReceived, String cardNumber) {
		super();
		this.amountReceived = amountReceived;
		this.cardNumber = cardNumber;
	}

	public DonorDto() {
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

	@Override
	public String toString() {
		return "DonorDto [amountReceived=" + amountReceived + ", cardNumber=" + cardNumber + "]";
	}

}
