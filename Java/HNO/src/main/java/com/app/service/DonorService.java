package com.app.service;

import java.util.List;

import com.app.dto.DonorLoginDto;
import com.app.dto.DonorStatusDto;
import com.app.pojos.Donor;

public interface DonorService {
	//Crud Operations
	List<Donor> getAllDonors(); 
	Donor addDonor(Donor donor);
	String deleteDonor(Long donorId);
	Donor getOneDonor(Long donId);
	Donor updateDonor(Donor don);
	//Main Functins
	Donor validateDon(DonorLoginDto don);
	List<Donor> getAllTrueDonors();
	String deleteFalseDonor(Long donorId);
}
