package com.app.dto.Vendor;

public class VendorLoginDto {
	
	private String vendorEmailId;

	private String vendorPassword;

	public VendorLoginDto(String vendorEmailId, String vendorPassword) {
		super();
		this.vendorEmailId = vendorEmailId;
		this.vendorPassword = vendorPassword;
	}

	public VendorLoginDto() {
		super();
	}

	public String getVendorEmailId() {
		return vendorEmailId;
	}

	public void setVendorEmailId(String vendorEmailId) {
		this.vendorEmailId = vendorEmailId;
	}

	public String getVendorPassword() {
		return vendorPassword;
	}

	public void setVendorPassword(String vendorPassword) {
		this.vendorPassword = vendorPassword;
	}

	@Override
	public String toString() {
		return "VendorLoginDto [vendorEmailId=" + vendorEmailId + ", vendorPassword=" + vendorPassword + "]";
	}
	

}
