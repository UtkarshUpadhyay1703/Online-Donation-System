package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="signup_employee")
//Lombok annotations
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = "employeePassword")
public class Employee extends BaseEntity{
	@Column(length=20, nullable = false)
	private String employeeName;
	@Column(length=100, nullable = false)
	private String employeeAddress;
	@Column(length=10,unique = true, nullable = false)
	private String employeeMobileNo;
	@Column(length=12,unique = true, nullable = false)
	private String employeeAadharNo;
	@Column(length=18, unique = true,nullable = false)
	private String employeeBankAccountNo;
	@Column(length = 30, unique = true, nullable = false)
	private String employeeEmailId;
	@Column(length = 20, nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)
	private String employeePassword;
	@Column(length=10, nullable = false)
	private String employeeQualification;
	@Column(length=10, nullable = false)
	private boolean employeeStatus;
	public Employee(String employeeName, String employeeAddress, String employeeMobileNo, String employeeAadharNo,
			String employeeBankAccountNo, String employeeEmailId, String employeePassword, String employeeQualification,
			boolean employeeStatus) {
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
				+ employeeBankAccountNo + ", employeeEmailId=" + employeeEmailId + ", employeePassword="
				+ employeePassword + ", employeeQualification=" + employeeQualification + ", employeeStatus=" + employeeStatus
				+ "]";
	}

	
}
