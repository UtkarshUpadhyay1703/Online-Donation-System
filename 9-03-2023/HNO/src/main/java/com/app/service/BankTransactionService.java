package com.app.service;

import com.app.pojos.BankTransaction;

public interface BankTransactionService {
	double getBalance();
	BankTransaction saveTransaction(BankTransaction transaction);
	boolean validateEmployee(Long id);
	BankTransaction depositBankTransaction(BankTransaction transaction);
}
