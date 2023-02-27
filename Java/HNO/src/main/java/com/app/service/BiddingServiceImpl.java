package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.pojos.Bidding;
import com.app.repository.BiddingRepository;

public class BiddingServiceImpl implements BiddingService {
	
	@Autowired
	BiddingRepository bidRepo;

	@Override
	public Bidding saveBid(Bidding bidding) {
		return bidRepo.save(bidding);
	}

}
