package com.app.dto;

public class DonorDto {
	private String donorName;

	private String donorAddress;

	private String donor_mobile_no;

	private String donorEmailId;

	private String donorPassword;

	private boolean donorStatus;

	public DonorDto(String donorName, String donorAddress, String donor_mobile_no, String donorEmailId,
			String donorPassword, boolean donorStatus) {
		super();
		this.donorName = donorName;
		this.donorAddress = donorAddress;
		this.donor_mobile_no = donor_mobile_no;
		this.donorEmailId = donorEmailId;
		this.donorPassword = donorPassword;
		this.donorStatus = donorStatus;
	}

	public DonorDto() {
		super();
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

	public String getDonor_mobile_no() {
		return donor_mobile_no;
	}

	public void setDonor_mobile_no(String donor_mobile_no) {
		this.donor_mobile_no = donor_mobile_no;
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

	public boolean isDonorStatus() {
		return donorStatus;
	}

	public void setDonorStatus(boolean donorStatus) {
		this.donorStatus = donorStatus;
	}

}
