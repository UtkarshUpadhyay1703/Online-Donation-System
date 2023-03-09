package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.BankTransaction;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long>{
	
	
//	@Query(value="select new com.app.pojos.BankTransaction(balance) from BankTransaction b order by b.createdOn desc limit 1")
	@Query(value="select * from bank_transaction b order by b.created_on desc limit 1",nativeQuery = true)
//	@Query(value="select new com.app.pojos.BankTransaction(balance) from BankTransaction b where id=6")
	BankTransaction findLatestBalance();
//	BankTransaction findLastBankTransactionOrderByCreatedOn();
//	@Query(value = "SELECT * FROM students ORDER BY id DESC LIMIT 1", nativeQuery = true) Object getLastStudentDetails();
	
//	@Query(value="select new com.app.pojos.BankTransaction(balance) from BankTransaction b where employee=?1 order by createdOn desc limit 1")
	@Query(value="select new com.app.pojos.BankTransaction(createdOn) from BankTransaction b where b.employee.id=1")
	BankTransaction validateEmployee(Long id);
	
}
