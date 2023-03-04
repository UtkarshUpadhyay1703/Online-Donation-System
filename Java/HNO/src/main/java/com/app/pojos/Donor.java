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
//	@Column
//	@Column(columnDefinition = "boolean default true")
	private boolean donorStatus;
//	@JsonBackReference
	@OneToMany(mappedBy = "donor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BankTransaction> transactions = new ArrayList<BankTransaction>();

	@OneToMany(mappedBy = "itemDonor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemDonation> items = new ArrayList<ItemDonation>();

//	@ManyToOne
//	@JoinColumn(name="donor_id")
//	private Employee donorEmployee;

	public Donor() {
		super();
	}



	public Donor(String donorName, String donorAddress, String donorMobileNo, String donorEmailId, String donorPassword,
		boolean donorStatus) {
	super();
	this.donorName = donorName;
	this.donorAddress = donorAddress;
	this.donorMobileNo = donorMobileNo;
	this.donorEmailId = donorEmailId;
	this.donorPassword = donorPassword;
	this.donorStatus = donorStatus;
}



	public String getDonorMobileNo() {
		return donorMobileNo;
	}

	public void setDonorMobileNo(String donorMobileNo) {
		this.donorMobileNo = donorMobileNo;
	}

//	public List<BankTransaction> getTransactions() {
//		return transactions;
//	}
//
//	public void setTransactions(List<BankTransaction> transactions) {
//		this.transactions = transactions;
//	}

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

	public void addBankTransaction(BankTransaction b) {
//		BankTransaction bank=new BankTransaction();
//		bank.deposit(b.getAmountSend());
		transactions.add(b);

		b.setDonor(this);
	}

	public void addItemDonor(ItemDonation id) {
		items.add(id);
		id.setItemDonor(this);

	}

//	public void removeBankTransaction(BankTransaction b) {
//		transactions.remove(b);
//		b.setDonor(null);
//	}

	@Override
	public String toString() {
		return "Donor id = " + getId() + "[donorName=" + donorName + ", donorAddress=" + donorAddress
				+ ", donor_mobile_no=" + donorMobileNo + ", donorEmailId=" + donorEmailId + ", donorStatus="
				+ donorStatus + "]";
	}

}
