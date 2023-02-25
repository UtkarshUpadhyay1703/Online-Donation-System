package com.app.service;

import com.app.pojos.BankTransaction;

public interface BankTransactionService {
	double getBalance();
	BankTransaction saveTransaction(BankTransaction transaction);
}
