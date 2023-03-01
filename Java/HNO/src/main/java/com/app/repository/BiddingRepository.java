package com.app.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Bidding;

public interface BiddingRepository extends JpaRepository<Bidding, Long>{
	@Query(value="select * from bidding b where b.date_of_bid>? and b.low_price_notebook !=0 order by b.low_price_notebook limit 5",nativeQuery = true)
	List<Bidding> getTopFiveBookBidders(LocalDateTime date);
}
