package com.app.dto.BankTransaction;

import com.app.pojos.Vendor;

public class VendorSendDto {
	private double amountSend;
	private Vendor vendors;

	public VendorSendDto(double amountSend, Vendor vendor1) {
		super();
		this.amountSend = amountSend;
		this.vendors = vendor1;
	}

	public double getAmountSend() {
		return amountSend;
	}

	public void setAmountSend(double amountSend) {
		this.amountSend = amountSend;
	}

	public Vendor getVendor() {
		return vendors;
	}

	public void setVendor(Vendor vendor) {
		this.vendors = vendor;
	}

	@Override
	public String toString() {
		return "VendorSendDto [amountSend=" + amountSend + "]";
	}

}
