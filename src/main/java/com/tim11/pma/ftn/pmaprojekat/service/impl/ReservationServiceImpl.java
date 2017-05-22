package com.tim11.pma.ftn.pmaprojekat.service.impl;

import java.util.List;

import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.repository.ReservationRepository;
import com.tim11.pma.ftn.pmaprojekat.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	@Autowired
	UserService userService;

	@Override
	public Reservation create(Reservation reservation) {
		//TODO: Probably not to save user here, but maybe yes
		User user = null;
		if ((user = userService.findUserByFbProfileId(reservation.getUser().getFbUser().getFbProfileId())) == null) {
			userService.save(reservation.getUser());
		} else {
			reservation.setUser(user);
		}
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getReservationsForUser(int userId) {
		return reservationRepository.findByUserId(userId);
	}

	@Override
	public List<Reservation> getReservationsForFbProfile(String fbProfileId) {
		return reservationRepository.findByUser_fbUser_fbProfileId(fbProfileId);
	}
}
