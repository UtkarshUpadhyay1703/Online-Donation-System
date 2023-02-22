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

import com.app.dto.DonorDto;
import com.app.dto.DonorLoginDto;
import com.app.pojos.Donor;
import com.app.service.DonorService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
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
	public Donor addDonor(@RequestBody DonorDto donor) {
		System.out.println("Donor add "+donor);
		Donor dno=mapper.map(donor,Donor.class);
		return donoServ.addDonor(dno);
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
	@PutMapping
	public Donor updateDonor(@RequestBody Donor don ) {
		return donoServ.updateDonor(don);
	}
	@PostMapping("/signIn")
	public Donor validateDonor(@RequestBody DonorLoginDto donLogIn) {
		System.out.println("login"+donLogIn);
		return donoServ.validateDon(donLogIn);
	}
	@GetMapping("/Donortrue")
	public List<Donor> getAllTrueDonor(){
		System.out.println("inside true");
		return donoServ.getAllTrueDonors();
	}
	@PutMapping("/{donId}")
	public String deleteFalseDonor(@PathVariable Long donId) {
		System.out.println("inside false");
		return donoServ.deleteFalseDonor(donId);
		
	}

}
