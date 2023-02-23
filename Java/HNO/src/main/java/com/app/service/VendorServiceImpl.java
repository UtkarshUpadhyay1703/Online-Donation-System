package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.Vendor.VendorLoginDto;
import com.app.pojos.Vendor;
import com.app.repository.VendorRepository;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository venRepo;

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
		
		return venRepo.findByVendorEmailIdAndVendorPassword(ven.getVendorEmailId(),ven.getVendorPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Email and password"));	
	}
	
	@Override
	public List<Vendor> getAllTrueVendors() {
		return venRepo.findByVendorStatus(true);
	}
	
	@Override
	public String deleteFalseVendor(Long vendorId) {
		if(venRepo.existsById(vendorId)) {
			venRepo.setVendorStatusToFalse(vendorId);
			return "set to false (Updated)";
		}
		throw new ResourceNotFoundException("Invalid Id");
	}

}
