package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "signup_employee")
public class Employee extends BaseEntity {
	@Column(length = 20, nullable = false)
	private String employeeName;
	@Column(length = 100, nullable = false)
	private String employeeAddress;
	@Column(length = 10, unique = true, nullable = false)
	private String employeeMobileNo;
	@Column(length = 12, unique = true, nullable = true)
//	@Column(length = 12)
	private String employeeAadharNo;
	@Column(length = 18, unique = true, nullable = true)
//	@Column(length = 18)
	private String employeeBankAccountNo;
//	@Pattern(regexp = "^[A-Z]{4}0[A-Z0-9]{6}$", message = "Please write right IFSC    Thank you!!!")
	@Column(length = 11, unique = true, nullable = true)
//	@Column(length = 11)
	private String employeeCompanyBankIFSC;
	@Column(length = 30, unique = true, nullable = false)
	private String employeeEmailId;
	@Column(length = 20, nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String employeePassword;
	@Column(length = 10, nullable = false)
	private String employeeQualification;
//	@Column(length = 10, nullable = false)
	@Column(columnDefinition = "boolean default true")
	private boolean employeeStatus;
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<BankTransaction> transactions = new ArrayList<BankTransaction>();

	@OneToMany(mappedBy = "itemEmployee", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OneToMany(mappedBy = "itemEmployee", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
	private List<ItemDonation> items = new ArrayList<ItemDonation>();

	public Employee(String employeeName, String employeeAddress, String employeeMobileNo, String employeeAadharNo,
			String employeeBankAccountNo, String employeeCompanyBankIFSC, String employeeEmailId,
			String employeePassword, String employeeQualification, boolean employeeStatus) {
		super();
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeMobileNo = employeeMobileNo;
		this.employeeAadharNo = employeeAadharNo;
		this.employeeBankAccountNo = employeeBankAccountNo;
		this.employeeCompanyBankIFSC = employeeCompanyBankIFSC;
		this.employeeEmailId = employeeEmailId;
		this.employeePassword = employeePassword;
		this.employeeQualification = employeeQualification;
		this.employeeStatus = employeeStatus;
	}


	public Employee() {
		super();
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeeAddress() {
		return employeeAddress;
	}


	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}


	public String getEmployeeMobileNo() {
		return employeeMobileNo;
	}


	public void setEmployeeMobileNo(String employeeMobileNo) {
		this.employeeMobileNo = employeeMobileNo;
	}


	public String getEmployeeAadharNo() {
		return employeeAadharNo;
	}


	public void setEmployeeAadharNo(String employeeAadharNo) {
		this.employeeAadharNo = employeeAadharNo;
	}


	public String getEmployeeBankAccountNo() {
		return employeeBankAccountNo;
	}


	public void setEmployeeBankAccountNo(String employeeBankAccountNo) {
		this.employeeBankAccountNo = employeeBankAccountNo;
	}


	public String getEmployeeCompanyBankIFSC() {
		return employeeCompanyBankIFSC;
	}


	public void setEmployeeCompanyBankIFSC(String employeeCompanyBankIFSC) {
		this.employeeCompanyBankIFSC = employeeCompanyBankIFSC;
	}


	public String getEmployeeEmailId() {
		return employeeEmailId;
	}


	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}


	public String getEmployeePassword() {
		return employeePassword;
	}


	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}


	public String getEmployeeQualification() {
		return employeeQualification;
	}


	public void setEmployeeQualification(String employeeQualification) {
		this.employeeQualification = employeeQualification;
	}


	public boolean isEmployeeStatus() {
		return employeeStatus;
	}


	public void setEmployeeStatus(boolean employeeStatus) {
		this.employeeStatus = employeeStatus;
	}


	public void addBankTransaction(BankTransaction b) {
		transactions.add(b);
		b.setEmployee(this);
	}

	public void addItemDonation(ItemDonation id) {
		items.add(id);
		id.setItemEmployee(this);
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeAddress=" + employeeAddress + ", employeeMobileNo="
				+ employeeMobileNo + ", employeeAadharNo=" + employeeAadharNo + ", employeeBankAccountNo="
				+ employeeBankAccountNo + ", employeeEmailId=" + employeeEmailId + ", employeeQualification="
				+ employeeQualification + ", employeeStatus=" + employeeStatus + "]";
	}

}
