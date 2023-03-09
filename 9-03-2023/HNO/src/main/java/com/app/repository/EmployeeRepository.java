package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	Optional<Employee> findByEmployeeEmailIdAndEmployeePassword(String em,String pass);
	List<Employee> findByEmployeeStatus(Boolean status);
	@Modifying
	@Query(value="update com.app.pojos.Employee set employee_status = false where id=?1")
	void setEmployeeStatusToFalse(Long id);
}
