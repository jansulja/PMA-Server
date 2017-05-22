package com.tim11.pma.ftn.pmaprojekat.service;

import java.util.List;

import com.tim11.pma.ftn.pmaprojekat.model.Reservation;

public interface ReservationService {

	Reservation create(Reservation reservation);

	List<Reservation> getReservationsForUser(int userId);

	List<Reservation> getReservationsForFbProfile(String id);
}
