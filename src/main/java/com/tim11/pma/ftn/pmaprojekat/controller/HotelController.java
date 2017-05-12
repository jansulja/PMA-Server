package com.tim11.pma.ftn.pmaprojekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;

@RestController("/hotel")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@GetMapping
	public List<Hotel> list(){
		
		return hotelService.findAll();
		
	}
	
}
