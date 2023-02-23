package com.app.dto.Employee;

public class EmployeeStatusDuo {
	
	private boolean employeeStatus;

	public EmployeeStatusDuo(boolean employeeStatus) {
		super();
		this.employeeStatus = employeeStatus;
	}

	public EmployeeStatusDuo() {
		super();
	}

	public boolean isEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(boolean employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	@Override
	public String toString() {
		return "EmployeeStatusDuo [employeeStatus=" + employeeStatus + "]";
	}

}
