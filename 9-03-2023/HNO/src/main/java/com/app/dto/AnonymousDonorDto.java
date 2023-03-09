package com.app.dto;

public class AnonymousDonorDto {

	// @Pattern(regexp = "^6(?!52[12])(?:011|5[0-9][0-9])[0-9]{12}$", message =
	// "Please write right Rupay Thank you!!!")
	private String cardNumber;
	private double amountReceived;

	public AnonymousDonorDto(String cardNumber, double amountReceived) {
		super();
		this.cardNumber = cardNumber;
		this.amountReceived = amountReceived;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public double getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(double amountReceived) {
		this.amountReceived = amountReceived;
	}

	@Override
	public String toString() {
		return "AnonymousDonorDto [cardNumber=" + cardNumber + ", amountReceived=" + amountReceived + "]";
	}

}
