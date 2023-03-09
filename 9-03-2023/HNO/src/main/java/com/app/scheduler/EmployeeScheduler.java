package com.app.scheduler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.app.dto.BankTransaction.EmployeeSendDto;
import com.app.pojos.BankTransaction;
import com.app.service.BankTransactionService;
import com.app.service.EmployeeService;

@Component
public class EmployeeScheduler {
	@Autowired
	private ModelMapper mapper;

	@Autowired
	private BankTransactionService bankService;

	@Autowired
	private EmployeeService empServ;

	@Scheduled(cron = "10 14 8 * * ?")
//	@PostMapping("/Transaction/withdraw/Employee")
//	public BankTransaction withdrawBankTransaction(@RequestBody EmployeeSendDto send) {
	public BankTransaction withdrawBankTransaction() {
		Long l = Long.valueOf(1);
		EmployeeSendDto send = new EmployeeSendDto(15000, empServ.getById(l));
		System.out.println("inside Trax in Employee send");
		BankTransaction transaction = mapper.map(send, BankTransaction.class);

		if (bankService.validateEmployee(transaction.getEmployee().getId())) {
			System.out.println("after validating inside transaction");
			return empServ.withdrawBankTransaction(transaction);
		}
		return null;
	}
}
