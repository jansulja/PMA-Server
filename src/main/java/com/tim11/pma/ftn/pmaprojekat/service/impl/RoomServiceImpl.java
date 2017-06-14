package com.tim11.pma.ftn.pmaprojekat.service.impl;

import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.repository.RoomRepository;
import com.tim11.pma.ftn.pmaprojekat.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomRepository roomRepository;

	@Override
	public Room findById(int roomId) {
		return roomRepository.findOne(roomId);
	}

	
}
