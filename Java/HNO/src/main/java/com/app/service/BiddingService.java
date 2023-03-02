package com.app.service;

import java.util.List;

import com.app.pojos.Bidding;

public interface BiddingService {
	Bidding saveBid(Bidding bidding); 
	List<Bidding> getRecentBiddingUpToFiveBooks();
	List<Bidding> getRecentBiddingUpToFiveCloths();
	List<Bidding> getRecentBiddingUpToFiveToys();
	List<Bidding> getRecentBiddingUpToFiveCycles();
	boolean setBiddingStatusToSelected(Long id);
	List<Bidding> getAllSelectedBidders();
	boolean setBiddingStatusToApproveBooks(Long id);
}
