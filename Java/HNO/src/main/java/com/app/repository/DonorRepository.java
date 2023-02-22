package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Donor;

public interface DonorRepository extends JpaRepository<Donor,Long> {

	Optional<Donor> findByDonorEmailIdAndDonorPassword(String em,String pass);
	List<Donor> findByDonorStatus(Boolean status);
//	Optional<Donor> set
	@Modifying
	@Query(value="update com.app.pojos.Donor set donor_status = false where id=?1")
	void setDonorStatusToFalse(Long id);
}
//findByDonorStatus