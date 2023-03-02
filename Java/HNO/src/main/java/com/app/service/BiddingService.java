package com.app.service;

import java.util.List;

import com.app.pojos.Bidding;

public interface BiddingService {
	Bidding saveBid(Bidding bidding); 
	List<Bidding> getRecentBiddingUpToFiveBooks();
}
