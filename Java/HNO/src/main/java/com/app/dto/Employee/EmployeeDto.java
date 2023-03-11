package com.app.dto.Employee;

public class EmployeeDto {

	private String employeeName;

	private String employeeAddress;

	private String employeeMobileNo;

	private String employeeAadharNo;

	private String employeeBankAccountNo;
	private String employeeCompanyBankIFSC;

	private String employeeEmailId;

	private String employeePassword;

	private String employeeQualification;

//	private boolean employeeStatus;

	public EmployeeDto() {
		super();
	}



	public EmployeeDto(String employeeName, String employeeAddress, String employeeMobileNo, String employeeAadharNo,
			String employeeBankAccountNo, String employeeCompanyBankIFSC, String employeeEmailId,
			String employeePassword, String employeeQualification) {
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
	}



	public String getEmployeeCompanyBankIFSC() {
		return employeeCompanyBankIFSC;
	}



	public void setEmployeeCompanyBankIFSC(String employeeCompanyBankIFSC) {
		this.employeeCompanyBankIFSC = employeeCompanyBankIFSC;
	}



	public String getEmployeeName() {
		return employeeName;
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



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	@Override
	public String toString() {
		return "EmployeeDto [employeeName=" + employeeName + ", employeeAddress=" + employeeAddress
				+ ", employeeMobileNo=" + employeeMobileNo + ", employeeAadharNo=" + employeeAadharNo
				+ ", employeeBankAccountNo=" + employeeBankAccountNo + ", employeeCompanyBankIFSC="
				+ employeeCompanyBankIFSC + ", employeeEmailId=" + employeeEmailId + ", employeePassword="
				+ employeePassword + ", employeeQualification=" + employeeQualification + "]";
	}



//	public boolean isEmployeeStatus() {
//		return employeeStatus;
//	}
//
//	public void setEmployeeStatus(boolean employeeStatus) {
//		this.employeeStatus = employeeStatus;
//	}

}
