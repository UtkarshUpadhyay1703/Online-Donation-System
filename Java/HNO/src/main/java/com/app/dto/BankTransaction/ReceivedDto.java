package com.app.dto.BankTransaction;

import com.app.pojos.Donor;

public class ReceivedDto {
	private double amountReceived;
	private Donor don;


	public ReceivedDto(double amountReceived, Donor don) {
		super();
		this.amountReceived = amountReceived;
		this.don = don;
	}

	public ReceivedDto() {
		super();
	}

	public Donor getDon() {
		return don;
	}

	public void setDon(Donor don) {
		this.don = don;
	}

	public double getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(double amountReceived) {
		this.amountReceived = amountReceived;
	}

	@Override
	public String toString() {
		return "ReceivedDto [amountReceived=" + amountReceived + "]";
	}

}
