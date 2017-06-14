package com.tim11.pma.ftn.pmaprojekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.service.ReservationService;
import com.tim11.pma.ftn.pmaprojekat.service.RoomService;

@RestController
@RequestMapping("reservation")
public class ReservationController {

	@Autowired
	ReservationService reservationService;
	
	@Autowired
	RoomService roomService;

	@PostMapping
	public Reservation create(@RequestBody Reservation reservation){
		return reservationService.create(reservation);
	}
	
	@RequestMapping(path = "/{fbProfileId}", method = RequestMethod.GET)
	public List<Reservation> getUserReservationList(@PathVariable String fbProfileId){
		List<Reservation> reservations = reservationService.getReservationsForFbProfile(fbProfileId);
		return reservations;
	}
	
	@RequestMapping(path = "/room/{roomId}", method = RequestMethod.GET)
	public Room getRoomById(@PathVariable int roomId){
		return roomService.findById(roomId);
	}
	
	
}
