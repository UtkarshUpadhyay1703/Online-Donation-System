package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Donor;

public interface DonorRepository extends JpaRepository<Donor,Long> {

}
