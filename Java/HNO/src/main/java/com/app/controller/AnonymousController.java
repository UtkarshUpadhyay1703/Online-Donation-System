package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AnonymousDonorDto;
import com.app.pojos.BankTransaction;
import com.app.service.BankTransactionService;


@RestController

@CrossOrigin(origins = "http://localhost:3000/")

@RequestMapping("/anonymous")
public class AnonymousController {

//	@Autowired
//	private ModelMapper mapper;
	
	@Autowired
	private BankTransactionService donoServ;
	
	@PostMapping("/deposit")
	public BankTransaction depositBankTransaction(@RequestBody AnonymousDonorDto anoDto) {
		System.out.println(anoDto);
		System.out.println("inside addTrax in donor send");
		BankTransaction transaction = new BankTransaction(anoDto.getAmountReceived(),anoDto.getCardNumber());
		return donoServ.depositBankTransaction(transaction);
	}
	
	
}
