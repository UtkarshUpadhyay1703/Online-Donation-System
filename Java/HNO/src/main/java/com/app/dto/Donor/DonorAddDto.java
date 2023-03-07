package com.app.dto.Donor;

public class DonorAddDto {
	private String donorName;

	private String donorAddress;

	private String donorMobileNo;

	private String donorEmailId;

	private String donorPassword;

//	private boolean donorStatus;



	public DonorAddDto() {
		super();
	}

	public DonorAddDto(String donorName, String donorAddress, String donorMobileNo, String donorEmailId,
		String donorPassword) {
	super();
	this.donorName = donorName;
	this.donorAddress = donorAddress;
	this.donorMobileNo = donorMobileNo;
	this.donorEmailId = donorEmailId;
	this.donorPassword = donorPassword;
}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public String getDonorAddress() {
		return donorAddress;
	}

	public void setDonorAddress(String donorAddress) {
		this.donorAddress = donorAddress;
	}

	public String getDonorMobileNo() {
		return donorMobileNo;
	}

	public void setDonorMobileNo(String donorMobileNo) {
		this.donorMobileNo = donorMobileNo;
	}

	public String getDonorEmailId() {
		return donorEmailId;
	}

	public void setDonorEmailId(String donorEmailId) {
		this.donorEmailId = donorEmailId;
	}

	public String getDonorPassword() {
		return donorPassword;
	}

	public void setDonorPassword(String donorPassword) {
		this.donorPassword = donorPassword;
	}

	@Override
	public String toString() {
		return "DonorAddDto [donorName=" + donorName + ", donorAddress=" + donorAddress + ", donorMobileNo="
				+ donorMobileNo + ", donorEmailId=" + donorEmailId + ", donorPassword=" + donorPassword + "]";
	}

//	public boolean isDonorStatus() {
//		return donorStatus;
//	}
//
//	public void setDonorStatus(boolean donorStatus) {
//		this.donorStatus = donorStatus;
//	}
	

}
