package com.app.service;

import java.util.List;

import com.app.dto.Donor.DonorLoginDto;
import com.app.pojos.BankTransaction;
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
	BankTransaction depositBankTransaction(BankTransaction transaction);
//	BankTransaction withdrawBankTransaction(BankTransaction Transaction);
}
