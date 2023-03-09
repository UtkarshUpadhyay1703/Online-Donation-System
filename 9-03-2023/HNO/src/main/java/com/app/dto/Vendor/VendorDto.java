package com.app.dto.Vendor;

public class VendorDto {
	private String vendorCompanyName;

	private String vendorCompanyAddress;

	private String vendorMobileNo;

	private String vendorAadharNo;

	private String vendorCompanyBankAccountNo;
	private String vendorCompanyBankIFSC;

	private String vendorEmailId;

	private String vendorPassword;

//	private boolean vendorStatus;

	public VendorDto() {
		super();
	}

	public VendorDto(String vendorCompanyName, String vendorCompanyAddress, String vendorMobileNo,
			String vendorAadharNo, String vendorCompanyBankAccountNo, String vendorCompanyBankIFSC,
			String vendorEmailId, String vendorPassword) {
		super();
		this.vendorCompanyName = vendorCompanyName;
		this.vendorCompanyAddress = vendorCompanyAddress;
		this.vendorMobileNo = vendorMobileNo;
		this.vendorAadharNo = vendorAadharNo;
		this.vendorCompanyBankAccountNo = vendorCompanyBankAccountNo;
		this.vendorCompanyBankIFSC = vendorCompanyBankIFSC;
		this.vendorEmailId = vendorEmailId;
		this.vendorPassword = vendorPassword;
	}

	public String getVendorCompanyName() {
		return vendorCompanyName;
	}

	public void setVendorCompanyName(String vendorCompanyName) {
		this.vendorCompanyName = vendorCompanyName;
	}

	public String getVendorCompanyAddress() {
		return vendorCompanyAddress;
	}

	public void setVendorCompanyAddress(String vendorCompanyAddress) {
		this.vendorCompanyAddress = vendorCompanyAddress;
	}

	public String getVendorMobileNo() {
		return vendorMobileNo;
	}

	public void setVendorMobileNo(String vendorMobileNo) {
		this.vendorMobileNo = vendorMobileNo;
	}

	public String getVendorAadharNo() {
		return vendorAadharNo;
	}

	public void setVendorAadharNo(String vendorAadharNo) {
		this.vendorAadharNo = vendorAadharNo;
	}

	public String getVendorCompanyBankAccountNo() {
		return vendorCompanyBankAccountNo;
	}

	public void setVendorCompanyBankAccountNo(String vendorCompanyBankAccountNo) {
		this.vendorCompanyBankAccountNo = vendorCompanyBankAccountNo;
	}

	public String getVendorCompanyBankIFSC() {
		return vendorCompanyBankIFSC;
	}

	public void setVendorCompanyBankIFSC(String vendorCompanyBankIFSC) {
		this.vendorCompanyBankIFSC = vendorCompanyBankIFSC;
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
		return "VendorDto [vendorCompanyName=" + vendorCompanyName + ", vendorCompanyAddress=" + vendorCompanyAddress
				+ ", vendorMobileNo=" + vendorMobileNo + ", vendorAadharNo=" + vendorAadharNo
				+ ", vendorCompanyBankAccountNo=" + vendorCompanyBankAccountNo + ", vendorCompanyBankIFSC="
				+ vendorCompanyBankIFSC + ", vendorEmailId=" + vendorEmailId + ", vendorPassword=" + vendorPassword
				+ "]";
	}

//	public boolean isVendorStatus() {
//		return vendorStatus;
//	}
//
//	public void setVendorStatus(boolean vendorStatus) {
//		this.vendorStatus = vendorStatus;
//	}

}
