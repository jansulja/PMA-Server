package com.tim11.pma.ftn.pmaprojekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.repository.ReservationRepository;
import com.tim11.pma.ftn.pmaprojekat.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public Reservation create(Reservation reservation) {
		//TODO: Need to
		return reservationRepository.save(reservation);
		
	}

	@Override
	public List<Reservation> getReservations(int userId) {
		return reservationRepository.findByUser(userId);
	}
	
	
}
