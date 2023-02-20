package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Donor;
import com.app.service.DonorService;

@RestController

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/donors")
public class DonorController {
	@Autowired
	private DonorService donoServ;

	public DonorController() {
		System.out.println("def cons"+getClass());
	}
	@GetMapping
	public List<Donor> getAllDOnors(){
		System.out.println("in all dono");
		return donoServ.getAllDonors();
	}
}
