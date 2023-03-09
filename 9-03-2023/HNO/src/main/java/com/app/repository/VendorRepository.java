package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
	
	Optional<Vendor> findByVendorEmailIdAndVendorPassword(String em,String pass);
	List<Vendor> findByVendorStatus(Boolean status);
	@Modifying
	@Query(value="update com.app.pojos.Vendor set vendor_status = false where id=?1")
	void setVendorStatusToFalse(Long id);
}


