package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.VendorLoginDto;
import com.app.pojos.Employee;
import com.app.pojos.Vendor;
import com.app.service.VendorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/vendors")
public class VendorController {
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
}
