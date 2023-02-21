package com.app.service;

import java.util.List;

import com.app.pojos.Donor;

public interface DonorService {
	List<Donor> getAllDonors(); 
	Donor addDonor(Donor donor);
	String deleteDonor(Long donorId);
	Donor getOneDonor(Long donId);
	Donor updateDonor(Donor don);
}
