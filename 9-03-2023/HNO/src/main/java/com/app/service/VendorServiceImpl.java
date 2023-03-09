package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.Vendor.VendorLoginDto;
import com.app.pojos.BankTransaction;
import com.app.pojos.Bidding;
import com.app.pojos.BiddingStatus;
import com.app.pojos.Vendor;
import com.app.repository.BankTransactionRepository;
import com.app.repository.BiddingRepository;
import com.app.repository.VendorRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	private BiddingRepository biddingRepo;

	@Autowired
	private VendorRepository venRepo;

	@Autowired
	private BankTransactionRepository bankRepo;

	@Override
	public List<Vendor> getAllVendors() {
		return venRepo.findAll();
	}

	@Override
	public Vendor addVendor(Vendor vendor) {
		return venRepo.save(vendor);
	}

	@Override
	public String deleteVendor(Long vendorId) {
		if (venRepo.existsById(vendorId)) {
			venRepo.deleteById(vendorId);
			return "Vendor delete successfully";
		}
		return "invalid so not been deleted";
	}

	@Override
	public Vendor getOneVendor(Long venId) {
		return venRepo.findById(venId).orElseThrow(() -> new ResourceNotFoundException("Invalid Vendor Id"));
	}

	@Override
	public Vendor updateVendor(Vendor ven) {
		if (venRepo.existsById(ven.getId())) {
			return venRepo.save(ven);
		}
		throw new ResourceNotFoundException("Invalid Vendor id so updation failed");
	}

	@Override
	public Vendor validateVen(VendorLoginDto ven) {

		return venRepo.findByVendorEmailIdAndVendorPassword(ven.getVendorEmailId(), ven.getVendorPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email and password"));
	}

	@Override
	public List<Vendor> getAllTrueVendors() {
		return venRepo.findByVendorStatus(true);
	}

	@Override
	public String deleteFalseVendor(Long vendorId) {
		if (venRepo.existsById(vendorId)) {
			venRepo.setVendorStatusToFalse(vendorId);
			return "set to false (Updated)";
		}
		throw new ResourceNotFoundException("Invalid Id");
	}

	@Override
	public BankTransaction withdrawBankTransaction(BankTransaction transaction) {
		System.out.println("inside withdraw of vendor");
		double balance = bankRepo.findLatestBalance().getBalance();
		transaction.setBalance(balance);
		transaction.setAmountReceived(0);
		transaction.withdraw(transaction.getAmountSend());
		System.out.println(transaction.getAmountSend());
		transaction.getVendor().addBankTransaction(transaction);
		return bankRepo.save(transaction);
	}

	@Override
	public Bidding addBidding(Bidding bidding) {
		System.out.println("inside adding bidding from vendor side");
		bidding.setBiddingStatusApprove(BiddingStatus.APPLIED);
		bidding.getVendor().addBidding(bidding);
		return biddingRepo.save(bidding);
	}
}
