package com.app.service;

import java.util.List;

import com.app.dto.Employee.EmployeeLoginDto;
import com.app.pojos.BankTransaction;
import com.app.pojos.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees(); 
	Employee getById(Long id);
	Employee addEmployee(Employee employee);
	String deleteEmployee(Long empId);
	Employee getOneEmployee(Long empId);
	Employee updateEmployee(Employee emp);
	Employee validateEmp(EmployeeLoginDto emp);
	List<Employee> getAllTrueEmployees();
	String deleteFalseEmployee(Long employeeId);
	//
	BankTransaction withdrawBankTransaction(BankTransaction transaction);
	double getCurrentBalance();
}
