package com.app.dto.Employee;

public class EmployeeLoginDto {
	
	private String employeeEmailId;

	private String employeePassword;

	public EmployeeLoginDto(String employeeEmailId, String employeePassword) {
		super();
		this.employeeEmailId = employeeEmailId;
		this.employeePassword = employeePassword;
	}

	public EmployeeLoginDto() {
		super();
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

	@Override
	public String toString() {
		return "EmployeeLoginDto [employeeEmailId=" + employeeEmailId + ", employeePassword=" + employeePassword + "]";
	}

	

}
