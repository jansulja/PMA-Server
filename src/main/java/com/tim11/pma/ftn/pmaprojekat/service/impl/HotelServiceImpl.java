package com.tim11.pma.ftn.pmaprojekat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.repository.HotelRepository;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public List<Hotel> findAll() {
		// TODO Auto-generated method stub
		List<Hotel> list = hotelRepository.findAll();
		return list;
	}

	@Override
	public void save(Hotel category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Hotel category) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Hotel categoryId) {
		// TODO Auto-generated method stub

	}

}
