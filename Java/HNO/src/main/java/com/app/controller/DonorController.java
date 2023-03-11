package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.BankTransaction.DonorDto;
import com.app.dto.BankTransaction.ReceivedDto;
import com.app.dto.Donor.DonorAddDto;
import com.app.dto.Donor.DonorLoginDto;
import com.app.pojos.BankTransaction;
import com.app.pojos.Donor;
import com.app.service.DonorService;

@RestController

@CrossOrigin(origins = "http://localhost:3000/")

@RequestMapping("/donors")
public class DonorController {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private DonorService donoServ;

	public DonorController() {
		System.out.println("def cons" + getClass());
	}

	@GetMapping
	public List<Donor> getAllDOnors() {
		System.out.println("in all dono");
		return donoServ.getAllDonors();
	}

	@PostMapping
	public Donor addDonor(@RequestBody DonorAddDto donor) {

//		System.out.println("Donor add " + donor);
//		Donor dno = mapper.map(donor, Donor.class);

		System.out.println("Donor add "+donor);
		Donor dno1=mapper.map(donor,Donor.class);

		dno1.setDonorStatus(true);
		System.out.println(dno1);
		return donoServ.addDonor(dno1);
	}

	@DeleteMapping("/{donId}")
	public String deleteDonor(@PathVariable Long donId) {
		System.out.println("in del id = " + donId);
		return donoServ.deleteDonor(donId);
	}

	@GetMapping("/{donId}")
	public Donor getOneDonor(@PathVariable Long donId) {
		return donoServ.getOneDonor(donId);
	}

	@PutMapping("/{donId}")
	public Donor updateDonor(@RequestBody Donor don,@PathVariable Long donId) {
		System.out.println("donor = "+don+"id = "+donId);
		don.setId(donId);
		return donoServ.updateDonor(don);
	}

	@PostMapping("/signIn")
	public Donor validateDonor(@RequestBody DonorLoginDto donLogIn) {
		System.out.println("login" + donLogIn);
		System.out.println(donoServ.validateDon(donLogIn));
		return donoServ.validateDon(donLogIn);
	}

	@GetMapping("/Donortrue")
	public List<Donor> getAllTrueDonor() {
		System.out.println("inside true");
		return donoServ.getAllTrueDonors();
	}

	@PutMapping("/false/{donId}")
	public String deleteFalseDonor(@PathVariable Long donId) {
		System.out.println("inside false");
		return donoServ.deleteFalseDonor(donId);
	}

	@PostMapping("/Transaction/deposit/{donId}")
	public BankTransaction depositBankTransaction(@RequestBody DonorDto money,@PathVariable Long donId) {
		ReceivedDto rec=new ReceivedDto(money.getAmountReceived(), money.getCardNumber(), donoServ.getOneDonor(Long.valueOf(donId)));
		System.out.println(rec.getDon());
		System.out.println("inside addTrax in donor send");
		BankTransaction transaction = new BankTransaction(rec.getDon(),rec.getAmountReceived(),rec.getCardNumber());
		return donoServ.depositBankTransaction(transaction);
	}
	
}
