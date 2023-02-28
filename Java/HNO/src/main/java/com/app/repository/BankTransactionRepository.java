package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.BankTransaction;

public interface BankTransactionRepository extends JpaRepository<BankTransaction, Long>{
	
	
//	@Query(value="select new com.app.pojos.BankTransaction(balance) from BankTransaction b order by createdOn desc limit 1")
	@Query(value="select new com.app.pojos.BankTransaction(balance) from BankTransaction b where id=5")
	BankTransaction findLatestBalance();
	
//	@Query(value="select new com.app.pojos.BankTransaction(balance) from BankTransaction b where employee_id=?1 order by createdOn desc limit 1")
	@Query(value="select new com.app.pojos.BankTransaction(createdOn) from BankTransaction b where employee_id=1")
	BankTransaction validateEmployee(Long id);
}
