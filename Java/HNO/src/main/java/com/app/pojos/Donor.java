package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "signup_donor")
//Lombok annotations
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString(exclude = "donorPassword")
public class Donor extends BaseEntity {
	@Column(length = 20, nullable = false)
	private String donorName;
	@Column(length = 100, nullable = false)
	private String donorAddress;
	@Column(length = 10, nullable = false)
	private String donorMobileNo;
	@Column(length = 30, unique = true, nullable = false)
	private String donorEmailId;
	@Column(length = 20, nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String donorPassword;
	@Column(length = 10, nullable = false)
	private boolean donorStatus;

	public Donor(String donorName, String donorAddress, String donorMobileNo, String donorEmailId,
			String donorPassword, boolean donorStatus) {
		super();
		this.donorName = donorName;
		this.donorAddress = donorAddress;
		this.donorMobileNo = donorMobileNo;
		this.donorEmailId = donorEmailId;
		this.donorPassword = donorPassword;
		this.donorStatus = donorStatus;
	}

	public Donor() {
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
		return donorMobileNo;
	}

	public void setDonor_mobile_no(String donorMobileNo) {
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

	public boolean isDonorStatus() {
		return donorStatus;
	}

	public void setDonorStatus(boolean donorStatus) {
		this.donorStatus = donorStatus;
	}

	@Override
	public String toString() {
		return "Donor [donorName=" + donorName + ", donorAddress=" + donorAddress + ", donor_mobile_no="
				+ donorMobileNo + ", donorEmailId=" + donorEmailId + ", donorStatus=" + donorStatus + "]";
	}

}
