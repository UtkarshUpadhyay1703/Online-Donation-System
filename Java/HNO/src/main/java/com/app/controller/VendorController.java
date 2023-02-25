package com.app.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import com.app.dto.BankTransaction.VendorSendDto;
import com.app.dto.Vendor.VendorLoginDto;
import com.app.pojos.BankTransaction;
=======
import com.app.dto.Vendor.VendorDto;
import com.app.dto.Vendor.VendorLoginDto;
>>>>>>> 61835576db8a054da0a37e4ee38f32aa6b92a7b7
import com.app.pojos.Vendor;
import com.app.service.VendorService;
import org.springframework.web.bind.annotation.RequestBody;



@RestController

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/vendors")
public class VendorController {
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private VendorService venServ;

	public VendorController() {
		System.out.println("def cons"+getClass());
	}
	@GetMapping
	public List<Vendor> getAllVendors(){
		System.out.println("in all dono");
		return venServ.getAllVendors();
	}
	@PutMapping
	public Vendor updateVendor(@RequestBody Vendor ven ) {
		return venServ.updateVendor(ven);
	}
	@PostMapping
	public Vendor addVendor(@RequestBody VendorDto vendor) {
		System.out.println("Vendor add"+vendor);
		Vendor vno=mapper.map(vendor,Vendor.class);
		vno.setVendorStatus(true);
		return venServ.addVendor(vno);
	}
	@PostMapping("/signIn")
	public Vendor validateVendor(@RequestBody VendorLoginDto venLogIn) {
		System.out.println("login"+venLogIn);
		return venServ.validateVen(venLogIn);
	}
	@GetMapping("/Vendortrue")
	public List<Vendor> getAllTrueVendor(){
		System.out.println("inside true");
		return venServ.getAllTrueVendors();
	}
	@PutMapping("/{venId}")
	public String deleteFalseVendor(@PathVariable Long venId) {
		System.out.println("inside false");
		return venServ.deleteFalseVendor(venId);
	}
	
	@PostMapping("/Transaction/withdraw/Vendor")
	public BankTransaction withdrawBankTransaction(@RequestBody VendorSendDto send) {
		System.out.println("inside addTrax in Vendor send");
		BankTransaction transaction = mapper.map(send, BankTransaction.class);
		return venServ.withdrawBankTransaction(transaction);
	}
}
