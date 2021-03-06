package com.tim11.pma.ftn.pmaprojekat.service.impl;

import com.tim11.pma.ftn.pmaprojekat.firebase.service.FcmService;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.repository.HotelRepository;
import com.tim11.pma.ftn.pmaprojekat.repository.RoomRepository;
import com.tim11.pma.ftn.pmaprojekat.service.RoomService;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;
	
	@Autowired
	HotelRepository hotelRepository;

	@Autowired
	FcmService fcmService;
	
	@Override
	public Room findById(int roomId) {
		return roomRepository.findOne(roomId);
	}

	@Override
	public void save(Room room) {
		roomRepository.save(room);
		
	}



	
}
