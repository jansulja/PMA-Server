package com.tim11.pma.ftn.pmaprojekat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;
import com.tim11.pma.ftn.pmaprojekat.viewmodel.SearchViewModel;

@RestController
@RequestMapping("hotel")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@GetMapping
	public List<Hotel> list(){
		
		return hotelService.findAll();
		
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public List<Hotel> search(@RequestBody SearchViewModel searchViewModel){
		
		List<Hotel> results = hotelService.search(searchViewModel);
		return results;
		
	}
	
}
