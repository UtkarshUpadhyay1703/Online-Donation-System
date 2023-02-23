package com.app.dto.Donor;

public class DonorStatusDto {

	private boolean donorStatus;

	public DonorStatusDto(boolean donorStatus) {
		super();
		this.donorStatus = donorStatus;
	}

	public DonorStatusDto() {
		super();
	}
	
	public boolean isDonorStatus() {
		return donorStatus;
	}

	public void setDonorStatus(boolean donorStatus) {
		this.donorStatus = donorStatus;
	}

	@Override
	public String toString() {
		return "DonorStatusDto [donorStatus=" + donorStatus + "]";
	}

}
