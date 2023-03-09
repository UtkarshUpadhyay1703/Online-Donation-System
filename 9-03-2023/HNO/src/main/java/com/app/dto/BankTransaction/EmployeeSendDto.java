package com.app.dto.BankTransaction;

import com.app.pojos.Employee;

public class EmployeeSendDto {
	private double amountSend;
	private Employee employee;

	public EmployeeSendDto(double amountSend, Employee employee) {
		super();
		this.amountSend = amountSend;
		this.employee = employee;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public EmployeeSendDto() {
		super();
	}

	public double getAmountSend() {
		return amountSend;
	}

	public void setAmountSend(double amountSend) {
		this.amountSend = amountSend;
	}

	@Override
	public String toString() {
		return "SendDto [amountSend=" + amountSend + "]";
	}

}
