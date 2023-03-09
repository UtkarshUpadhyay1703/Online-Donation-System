package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.Employee.EmployeeLoginDto;
import com.app.pojos.BankTransaction;
import com.app.pojos.Employee;
import com.app.repository.BankTransactionRepository;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private BankTransactionRepository bankRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}
	
	@Override
	public Employee getById(Long id) {
		return empRepo.getById(id);
	}
	
	@Override
	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Override
	public String deleteEmployee(Long employeeId) {
		if (empRepo.existsById(employeeId)) {
			empRepo.deleteById(employeeId);
			return "Vendor delete successfully";
		}
		return "invalid so not been deleted";
	}

	@Override
	public Employee getOneEmployee(Long empId) {
		return empRepo.findById(empId).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		if (empRepo.existsById(emp.getId())) {
			return empRepo.save(emp);
		}
		throw new ResourceNotFoundException("Invalid Vendor id so updation failed");
	}
	
	@Override
	public Employee validateEmp(EmployeeLoginDto emp) {
		
		return empRepo.findByEmployeeEmailIdAndEmployeePassword(emp.getEmployeeEmailId(), emp.getEmployeePassword())
	   .orElseThrow(() -> new ResourceNotFoundException("Invalid Email and password"));	
	}
	
	@Override
	public List<Employee> getAllTrueEmployees() {
		return empRepo.findByEmployeeStatus(true);
	}
	
	@Override
	public String deleteFalseEmployee(Long employeeId) {
		if(empRepo.existsById(employeeId)) {
			empRepo.setEmployeeStatusToFalse(employeeId);
			return "set to false (Updated)";
		}
		throw new ResourceNotFoundException("Invalid Id");
	}

	@Override
	public BankTransaction withdrawBankTransaction(BankTransaction transaction) {
		System.out.println("withdrawBankTransaction");
		double balance=bankRepo.findLatestBalance().getBalance();
		System.out.println("Current balance = "+balance);
		transaction.setBalance(balance);
		transaction.setAmountReceived(0);
		transaction.withdraw(transaction.getAmountSend());
		System.out.println(transaction.getAmountSend());
		transaction.getEmployee().addBankTransaction(transaction);
		return bankRepo.save(transaction);
	}
	
	@Override
	public double getCurrentBalance() {
		return bankRepo.findLatestBalance().getBalance();
	}

}
