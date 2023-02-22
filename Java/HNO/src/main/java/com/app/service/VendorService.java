package com.app.service;

import java.util.List;

import com.app.dto.VendorLoginDto;
import com.app.pojos.Vendor;

public interface VendorService {
	//Crud Operations
	List<Vendor> getAllVendors(); 
	Vendor addVendor(Vendor vendor);
	String deleteVendor(Long venId);
	Vendor getOneVendor(Long venId);
	Vendor updateVendor(Vendor ven);
	//Main Functions
	Vendor validateVen(VendorLoginDto ven);
	List<Vendor> getAllTrueVendors();
	String deleteFalseVendor(Long vendorId);
}