package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
