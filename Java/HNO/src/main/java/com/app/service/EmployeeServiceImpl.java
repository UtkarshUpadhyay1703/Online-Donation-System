package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.EmployeeLoginDto;
import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
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

}
