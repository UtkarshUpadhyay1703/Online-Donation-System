package com.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Bidding;

public interface BiddingRepository extends JpaRepository<Bidding, Long>{
	@Query(value="select * from bidding b where b.date_of_bid>? and b.low_price_notebook !=0 order by b.low_price_notebook limit 5",nativeQuery = true)
	List<Bidding> getTopFiveBookBidders(LocalDateTime date);

	@Query(value="select * from bidding b where b.date_of_bid>? and b.low_price_cloth !=0 order by b.low_price_cloth limit 5",nativeQuery = true)
	List<Bidding> getTopFiveClothsBidders(LocalDateTime date);

	@Query(value="select * from bidding b where b.date_of_bid>? and b.low_price_toy !=0 order by b.low_price_toy limit 5",nativeQuery = true)
	List<Bidding> getTopFiveToyBidders(LocalDateTime date);

	@Query(value="select * from bidding b where b.date_of_bid>? and b.low_price_cycle !=0 order by b.low_price_cycle limit 5",nativeQuery = true)
	List<Bidding> getTopFiveCycleBidders(LocalDateTime date);
	
	
	//bidding_status_approve
	@Modifying
	@Query(value="update com.app.pojos.Bidding set bidding_status_approve = ?1,quantity=?2 where id=?3")
	void setBiddingStatusAndQuantity(String status,int qty,Long id);
	
	@Query(value="select * from bidding b where b.date_of_bid>? and b.bidding_status_approve = 'SELECTED'",nativeQuery = true)
	List<Bidding> getSelectedBidders(LocalDateTime date);
	
	@Modifying
	@Query(value="update com.app.pojos.Bidding set bidding_status_approve= ?1 where id=?2")
	void setBiddingStatus(String status,Long id);
	
}
