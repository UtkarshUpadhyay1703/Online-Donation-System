package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Bidding;

public interface BiddingRepository extends JpaRepository<Bidding, Long>{
	
}
