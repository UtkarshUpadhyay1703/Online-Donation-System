package com.app.dto.Donor;

public class DonorLoginDto {

	private String donorEmailId;
	private String donorPassword;

	public DonorLoginDto(String donorEmailId, String donorPassword) {
		super();
		this.donorEmailId = donorEmailId;
		this.donorPassword = donorPassword;
	}

	public DonorLoginDto() {
		super();
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
		return "DonorLoginDto [donorEmailId=" + donorEmailId + ", donorPassword=" + donorPassword + "]";
	}

}
