package com.app.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.BankTransaction;
import com.app.pojos.Bidding;
import com.app.repository.BiddingRepository;

@Service
@Transactional
public class BiddingServiceImpl implements BiddingService {
	
	@Autowired
	BiddingRepository bidRepo;

	@Override
	public Bidding saveBid(Bidding bidding) {
		return bidRepo.save(bidding);
	}
	
	@Override
	public List<Bidding> getRecentBiddingUpToFiveBooks(){
		LocalDateTime biddingStartDate= LocalDateTime.now().minusDays(2);
		System.out.println("2 days before = "+biddingStartDate);
		return bidRepo.getTopFiveBookBidders(biddingStartDate);
	}
}
