package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.app.repository.BankTransactionRepository;
import com.app.repository.DonorRepository;
import com.app.repository.ItemDonationRepository;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
	
//	@Autowired
//	private DonorRepository donRepo;
	
//	@Autowired
//	private BankTransactionRepository bankRepo;
//	
//	@Autowired
//	private ItemDonationRepository itemRepo;
	
	
	
	
//	@JsonBackReference
	@OneToMany(mappedBy = "donor", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
//	@OneToMany(mappedBy = "donor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BankTransaction> transactions = new ArrayList<BankTransaction>();
//	private List<BankTransaction> transactions=bankRepo.findAll();
	
	
//	@JsonBackReference
	@OneToMany(mappedBy = "itemDonor", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OneToMany(mappedBy = "itemDonor", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<ItemDonation> items = new ArrayList<ItemDonation>();
//	private List<ItemDonation> items=itemRepo.findAll();

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



//	public List<BankTransaction> getTransactions() {
//		return transactions;
//	}
//
//
//
//	public void setTransactions(List<BankTransaction> transactions) {
//		this.transactions = transactions;
//	}
//
//
//
//	public List<ItemDonation> getItems() {
//		return items;
//	}
//
//
//
//	public void setItems(List<ItemDonation> items) {
//		this.items = items;
//	}



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
				+ ", donorMobileNo=" + donorMobileNo + ", donorEmailId=" + donorEmailId + ", donorStatus="
				+ donorStatus + "]";
	}

}
