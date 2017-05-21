package com.tim11.pma.ftn.pmaprojekat.service;

import java.util.List;

import com.tim11.pma.ftn.pmaprojekat.model.Reservation;

public interface ReservationService {

	public Reservation create(Reservation reservation);

	public List<Reservation> getReservations(String email);
}
