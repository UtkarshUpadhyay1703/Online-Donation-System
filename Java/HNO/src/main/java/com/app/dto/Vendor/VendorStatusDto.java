package com.app.dto.Vendor;

public class VendorStatusDto {
	
	private boolean vendorStatus;

	public VendorStatusDto(boolean vendorStatus) {
		super();
		this.vendorStatus = vendorStatus;
	}

	public VendorStatusDto() {
		super();
	}

	public boolean isVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(boolean vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	@Override
	public String toString() {
		return "VendorStatusDto [vendorStatus=" + vendorStatus + "]";
	}
	
}
