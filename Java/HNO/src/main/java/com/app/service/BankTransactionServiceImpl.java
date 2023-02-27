package com.app.service;

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
		return 0;
	}
	@Override
	public BankTransaction saveTransaction(BankTransaction transaction) {
		return bankRepo.save(transaction);
	}
}