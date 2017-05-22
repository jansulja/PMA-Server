package com.tim11.pma.ftn.pmaprojekat.repository;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	
}
