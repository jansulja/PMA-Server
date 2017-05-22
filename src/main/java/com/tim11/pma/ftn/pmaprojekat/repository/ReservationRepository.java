package com.tim11.pma.ftn.pmaprojekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tim11.pma.ftn.pmaprojekat.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

	public List<Reservation> findByUser(int id);
	
}
