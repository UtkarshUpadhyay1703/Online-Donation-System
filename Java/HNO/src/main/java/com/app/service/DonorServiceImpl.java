package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.Donor.DonorLoginDto;
import com.app.pojos.BankTransaction;
import com.app.pojos.Donor;
import com.app.pojos.ItemDonation;
import com.app.repository.BankTransactionRepository;
import com.app.repository.DonorRepository;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorRepository donRepo;

	@Autowired
	private BankTransactionRepository bankRepo;
	
	@Override
	public List<Donor> getAllDonors() {
		return donRepo.findAll();
	}

	@Override
	public Donor addDonor(Donor donor) {
		System.out.println(donor);
		return donRepo.save(donor);
	}

	@Override
	public String deleteDonor(Long donorId) {
		if (donRepo.existsById(donorId)) {
			donRepo.deleteById(donorId);
			return "Donor delete successfully";
		}
		return "invalid so not been deleted";
	}

	@Override
	public Donor getOneDonor(Long donId) {
		return donRepo.findById(donId).orElseThrow(() -> new ResourceNotFoundException("Invalid Donator Id"));
	}

	@Override
	public Donor updateDonor(Donor don) {
		if (donRepo.existsById(don.getId())) {
			return donRepo.save(don);
		}
		throw new ResourceNotFoundException("Invalid Donor id so updation failed");
	}

	@Override
	public Donor validateDon(DonorLoginDto don) {

		return donRepo.findByDonorEmailIdAndDonorPassword(don.getDonorEmailId(), don.getDonorPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email or password"));
	}

	@Override
	public List<Donor> getAllTrueDonors() {
		return donRepo.findByDonorStatus(true);
	}

	@Override
	public String deleteFalseDonor(Long donorId) {
		if(donRepo.existsById(donorId)) {
			donRepo.setDonorStatusToFalse(donorId);	
			return "set to false (Updated)";
		}
		throw new ResourceNotFoundException("Invalid Id");		
	}
	
	@Override
	public BankTransaction depositBankTransaction(BankTransaction transaction) {
		double balance=bankRepo.findLatestBalance().getBalance();
		transaction.setBalance(balance);
		transaction.setAmountSend(0);
//		BankTransaction bank=new BankTransaction();
//		bank.deposit(balance);
		transaction.deposit(transaction.getAmountReceived());
//		Donor don=new Donor();
		System.out.println(transaction.getDonor());
		transaction.getDonor().addBankTransaction(transaction);
		return bankRepo.save(transaction);
	}

	
//	@Override
//	public List<Donor> findAllTransaction(){
//		return donRepo.findAllDonorTransactions();
//	}
	
	
//	   public Donor getDonorById(Long id) {
//	        return donRepo.findByIdWithTransactionsAndItems(id)
//	                               .orElseThrow(() -> new ResourceNotFoundException("Donor"+ "id"+ id));
//	    }
	
	
	public Donor findDonorById(Long id) {
        return donRepo.findById(id).orElse(null);
    }

//    public List<BankTransaction> findTransactionsByDonorId(Long id) {
//        Donor donor = donRepo.findById(id).orElse(null);
//        return donor != null ? donor.getTransactions() : null;
//    }
//
//    public List<ItemDonation> findItemsByDonorId(Long id) {
//        Donor donor = donRepo.findById(id).orElse(null);
//        return donor != null ? donor.getItems() : null;
//    }
	
	
	
	
//	@Override
//	public BankTransaction withdrawBankTransaction(BankTransaction Transaction) {
//		
//		return null;
//	}
	
}