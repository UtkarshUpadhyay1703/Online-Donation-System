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
@Table(name = "signup_employee")
public class Employee extends BaseEntity {
	@Column(length = 20, nullable = false)
	private String employeeName;
	@Column(length = 100, nullable = false)
	private String employeeAddress;
	@Column(length = 10, unique = true, nullable = false)
	private String employeeMobileNo;
	@Column(length = 12, unique = true, nullable = false)
	private String employeeAadharNo;
	@Column(length = 18, unique = true, nullable = false)
	private String employeeBankAccountNo;
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

	public Employee(String employeeName, String employeeAddress, String employeeMobileNo, String employeeAadharNo,
			String employeeBankAccountNo, String employeeEmailId, String employeePassword, String employeeQualification,
			boolean employeeStatus, List<BankTransaction> transactions) {
		super();
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.employeeMobileNo = employeeMobileNo;
		this.employeeAadharNo = employeeAadharNo;
		this.employeeBankAccountNo = employeeBankAccountNo;
		this.employeeEmailId = employeeEmailId;
		this.employeePassword = employeePassword;
		this.employeeQualification = employeeQualification;
		this.employeeStatus = employeeStatus;
		this.transactions = transactions;
	}
	
	

	public List<BankTransaction> getTransactions() {
		return transactions;
	}



	public void setTransactions(List<BankTransaction> transactions) {
		this.transactions = transactions;
	}



	public boolean isEmployeeStatus() {
		return employeeStatus;
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

	public boolean isemployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(boolean employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeAddress=" + employeeAddress + ", employeeMobileNo="
				+ employeeMobileNo + ", employeeAadharNo=" + employeeAadharNo + ", employeeBankAccountNo="
				+ employeeBankAccountNo + ", employeeEmailId=" + employeeEmailId + ", employeeQualification="
				+ employeeQualification + ", employeeStatus=" + employeeStatus + "]";
	}

}
