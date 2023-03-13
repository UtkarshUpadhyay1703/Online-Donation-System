package com.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.pojos.BankTransaction;
import com.app.pojos.Donor;

public interface DonorRepository extends JpaRepository<Donor,Long> {

	Optional<Donor> findByDonorEmailIdAndDonorPassword(String em,String pass);
	List<Donor> findByDonorStatus(Boolean status);
	@Modifying
	@Query(value="update com.app.pojos.Donor set donor_status = false where id=?1")
	void setDonorStatusToFalse(Long id);
	
//	@Query(value = "SELECT d FROM com.app.pojos.Donor d JOIN FETCH d.transactions ")
//	ArrayList<BankTransaction> fetchAllDonorTransactins();
//	@Query(value = "select distinct d from Donor d left join fetch d.transactions")
//	List<Donor> findAllDonorTransactions();

	
//	    @Query("SELECT d FROM Donor d JOIN FETCH d.transactions t JOIN FETCH d.items i WHERE d.id = :id")
//	    Optional<Donor> findByIdWithTransactionsAndItems(@Param("id") Long id);
	


}
