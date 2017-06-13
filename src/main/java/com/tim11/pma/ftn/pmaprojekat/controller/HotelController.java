package com.tim11.pma.ftn.pmaprojekat.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tim11.pma.ftn.pmaprojekat.firebase.service.FcmService;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;
import com.tim11.pma.ftn.pmaprojekat.dto.SearchViewModel;

@RestController
@RequestMapping("hotel")
public class HotelController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	HotelService hotelService;
	
	@Autowired
	FcmService fcmService;
	
	@GetMapping
	public List<Hotel> list() {
		logger.info("Get all hotel list endpoint called!");
		return hotelService.findAll();
	}

	@PostMapping(path = "/ids")
	public List<Hotel> listWanted(@RequestBody Integer[] ids) {
		logger.info("Get hotel with ids: "
				+ String.join(", ", Stream.of(ids).map(Object::toString).collect(Collectors.toList())) + "");
		return hotelService.findAllByIds(ids);
	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public List<Hotel> search(@RequestBody SearchViewModel searchViewModel){
		logger.info("Search hotel with search parameters: " + searchViewModel.toString() + " called!");
		List<Hotel> results = hotelService.search(searchViewModel);
		return results;
		
	}
	
	@RequestMapping(path = "/fcm", method = RequestMethod.GET)
	public void fcmTest(){
		fcmService.sendPushMessage("this is message from spring boot server..");
	}
	
}
