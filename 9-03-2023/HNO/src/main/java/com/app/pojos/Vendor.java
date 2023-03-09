package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "signup_vendor")
public class Vendor extends BaseEntity {
	@Column(length = 20, nullable = false)
	private String vendorCompanyName;
	@Column(length = 100, nullable = false)
	private String vendorCompanyAddress;
	@Column(length = 10, unique = true, nullable = false)
	private String vendorMobileNo;
//	@Pattern(regexp = "^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$", message = "Please write right Aadhar Number    Thank you!!!")
	@Column(length=18,unique = true, nullable = false)
	private String vendorAadharNo;
//	@Pattern(regexp = ”^[0-9]{9,18}$”, message = "Please write right Account Number    Thank you!!!")  
	@Column(length=18,unique = true, nullable = false)
	private String vendorCompanyBankAccountNo;
//	@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Please write right IFSC    Thank you!!!")
	@Column(length=11,unique = true, nullable = false)
	private String vendorCompanyBankIFSC;
	@Column(length = 30, unique = true, nullable = false)
	private String vendorEmailId;
	@Column(length = 20, nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String vendorPassword;
//	@Column(length = 10, nullable = false)
	@Column(columnDefinition = "boolean default true")
	private boolean vendorStatus;
	@OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BankTransaction> transactions = new ArrayList<BankTransaction>();

	@OneToMany(mappedBy = "vendorBidding",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Bidding> biddings=new ArrayList<Bidding>();
	
	public Vendor(String vendorCompanyName, String vendorCompanyAddress, String vendorMobileNo, String vendorAadharNo,
			String vendorCompanyBankAccountNo, String vendorEmailId, String vendorPassword, boolean vendorStatus) {
		super();
		this.vendorCompanyName = vendorCompanyName;
		this.vendorCompanyAddress = vendorCompanyAddress;
		this.vendorMobileNo = vendorMobileNo;
		this.vendorAadharNo = vendorAadharNo;
		this.vendorCompanyBankAccountNo = vendorCompanyBankAccountNo;
		this.vendorEmailId = vendorEmailId;
		this.vendorPassword = vendorPassword;
		this.vendorStatus = vendorStatus;
	}

	public Vendor() {
		super();
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

	public boolean isVendorStatus() {
		return vendorStatus;
	}

	public void setVendorStatus(boolean vendorStatus) {
		this.vendorStatus = vendorStatus;
	}

	public void addBankTransaction(BankTransaction b) {
		transactions.add(b);
		b.setVendor(this);
	}
	public void addBidding(Bidding b) {
		biddings.add(b);
		b.setVendor(this);
	}

	@Override
	public String toString() {
		return "Vendor [vendorCompanyName=" + vendorCompanyName + ", vendorCompanyAddress=" + vendorCompanyAddress
				+ ", vendorMobileNo=" + vendorMobileNo + ", vendorAadharNo=" + vendorAadharNo
				+ ", vendorCompanyBankAccountNo=" + vendorCompanyBankAccountNo + ", vendorEmailId=" + vendorEmailId
				+ ", vendorStatus=" + vendorStatus + "]";
	}

}
