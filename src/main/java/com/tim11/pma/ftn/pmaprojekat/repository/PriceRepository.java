package com.tim11.pma.ftn.pmaprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tim11.pma.ftn.pmaprojekat.model.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
	
}
