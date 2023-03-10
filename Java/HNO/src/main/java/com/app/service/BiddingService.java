package com.app.service;

import java.util.List;

import com.app.pojos.Bidding;

public interface BiddingService {
	Bidding saveBid(Bidding bidding); 
	List<Bidding> getRecentBiddingUpToFiveBooks();
	List<Bidding> getRecentBiddingUpToFiveCloths();
	List<Bidding> getRecentBiddingUpToFiveToys();
	List<Bidding> getRecentBiddingUpToFiveCycles();
	boolean setBiddingStatusToSelectedBook(Long id);
	boolean setBiddingStatusToSelectedCycle(Long id);
	boolean setBiddingStatusToSelectedCloth(Long id);
	boolean setBiddingStatusToSelectedToy(Long id);
	List<Bidding> getAllSelectedBidders();
	boolean setBiddingStatusToApproveBook(Long id);
	boolean setBiddingStatusToApproveCloth(Long id);
	boolean setBiddingStatusToApproveToy(Long id);
	boolean setBiddingStatusToApproveCycle(Long id);
}
