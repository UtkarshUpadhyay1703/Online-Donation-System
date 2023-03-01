package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BankTransaction.EmployeeSendDto;
import com.app.dto.Employee.EmployeeDto;
import com.app.dto.Employee.EmployeeLoginDto;
import com.app.pojos.BankTransaction;
import com.app.pojos.Employee;
import com.app.service.BankTransactionService;
import com.app.service.EmployeeService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	private ModelMapper mapper;
	@Autowired
	private BankTransactionService bankService;
	
	@Autowired
	private EmployeeService empServ;

	public EmployeeController() {
		System.out.println("def cons" + getClass());
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		System.out.println("in all dono");
		return empServ.getAllEmployees();
	}

	@PostMapping
	public Employee addEmployee(@RequestBody EmployeeDto employee) {
		System.out.println("Employee add "+employee);
		Employee empno=mapper.map(employee,Employee.class);
		empno.setEmployeeStatus(true);
		return empServ.addEmployee(empno);
	}

	@DeleteMapping("/{empId}")
	public String deleteDonor(@PathVariable Long empId) {
		System.out.println("in del id = " + empId);
		return empServ.deleteEmployee(empId);
	}
	@GetMapping("/{empId}")
	public Employee getOneEmployee(@PathVariable Long empId) {
		return empServ.getOneEmployee(empId);
	}
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee emp ) {
		return empServ.updateEmployee(emp);
	}
	
	@PostMapping("/signIn")
	public Employee validateEmployee(@RequestBody EmployeeLoginDto empLogIn )
	{
		System.out.println("login"+empLogIn);
		return empServ.validateEmp(empLogIn);
	}
	
	@GetMapping("/Employeetrue")
	public List<Employee> getAllTrueEmployee(){
		System.out.println("inside true");
		return empServ.getAllTrueEmployees();
	}
	
	@PutMapping("/{empId}")
	public String deleteFalseEmployee(@PathVariable Long empId) {
		System.out.println("inside false");
		return empServ.deleteFalseEmployee(empId);
	}
	
	@PostMapping("/Transaction/withdraw/Employee")
	public BankTransaction withdrawBankTransaction(@RequestBody EmployeeSendDto send) {
		System.out.println("inside Trax in Employee send");
		BankTransaction transaction = mapper.map(send, BankTransaction.class);
		
		//Not right but check how to do with jwt 
		if(bankService.validateEmployee(transaction.getEmployee().getId())){
			System.out.println("after validating inside transaction");
		return empServ.withdrawBankTransaction(transaction);
		}
		return null;
	}
	
//	@PostMapping("/Transaction/withdraw/{empId}")
//	public BankTransaction withdrawBankTransaction(@PathVariable String empId) {
//		System.out.println("inside addTrax in Employee empId"+empId);
////		BankTransaction transaction = mapper.map(send, BankTransaction.class);
//		
//		//Not right but check how to do with jwt 
//		if(bankService.validateEmployee(empId)){
//		return empServ.withdrawBankTransaction(transaction);
//		}
//		return null;
//	}

}                  
