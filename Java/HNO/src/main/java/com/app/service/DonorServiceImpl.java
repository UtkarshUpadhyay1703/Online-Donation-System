package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.pojos.Donor;
import com.app.repository.DonorRepository;

@Service
@Transactional
public class DonorServiceImpl implements DonorService {


	@Autowired
	private DonorRepository donRepo;

	@Override
	public List<Donor> getAllDonors() {
		return donRepo.findAll();
	}

	@Override
	public Donor addDonor(Donor donor) {
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

}
