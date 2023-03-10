package com.app.service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.BankTransaction;
import com.app.repository.BankTransactionRepository;
@Service
@Transactional
public class BankTransactionServiceImpl implements BankTransactionService {
	@Autowired
	BankTransactionRepository bankRepo;
	@Override
	public double getBalance() {
		return bankRepo.findLatestBalance().getBalance();
	}
	@Override
	public BankTransaction saveTransaction(BankTransaction transaction) {
		return bankRepo.save(transaction);
	}
	
	@Override
	public boolean validateEmployee(Long id) {
		BankTransaction tranx= bankRepo.validateEmployee(id);
        LocalDateTime time= tranx.getCreatedOn();
        LocalDate currentDate=LocalDate.now();
		if(time.getMonth()==currentDate.getMonth()&&time.getYear()==currentDate.getYear()) {
			return false;
		}
		return true;
	}
	
	@Override
	public BankTransaction depositBankTransaction(BankTransaction transaction) {
		double balance=bankRepo.findLatestBalance().getBalance();
		transaction.setBalance(balance);
		transaction.setAmountSend(0);
		transaction.deposit(transaction.getAmountReceived());
		return bankRepo.save(transaction);
	}
	
}
