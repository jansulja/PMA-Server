package com.tim11.pma.ftn.pmaprojekat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tim11.pma.ftn.pmaprojekat.dto.SearchViewModel;
import com.tim11.pma.ftn.pmaprojekat.firebase.service.FcmService;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Price;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;
import com.tim11.pma.ftn.pmaprojekat.service.PriceService;
import com.tim11.pma.ftn.pmaprojekat.service.RoomService;

@RestController
@RequestMapping("hotel")
public class HotelController {

	protected final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	HotelService hotelService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	PriceService priceService;
	
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
	
	@RequestMapping(path = "/fcm/test/addnewroom/{hotelId}", method = RequestMethod.GET)
	public void fcmAddNewRoomTest(@PathVariable int hotelId){
		
		Random rand = new Random();
		
		Room r = new Room();
		r.setName("New room " + rand.nextInt(10000));
		r.setAmenities(new HashSet<>());
		r.setAvailable(5);
		r.setCount(8);
		r.setDescription("Description of room : " + r.getName());
		r.setReservations(new HashSet<>());
		r.setRoomBeds(new HashSet<>());
		
		Price p = new Price();
		p.setStartDate(new Date());
		p.setEndDate(new Date());
		p.setValue(22.22);
		priceService.save(p);
		r.setPrice(p);
		
		Map<String, Object> data = new HashMap<>();
	    
		Hotel h = hotelService.addRoomToHotel(hotelId, r);
		data.put("hotel_id", String.valueOf(hotelId));
		fcmService.sendPushMessage("New offer", h.getName() +" just registered a new room.", "hotel_"+String.valueOf(hotelId), data, "new_room");
	}
	
	@RequestMapping(path = "/fcm/test/changeroomprice/{roomId}", method = RequestMethod.GET)
	public void fcmChangeRoomPrice(@PathVariable int roomId,@RequestParam double newValue){

		Room r = roomService.findById(roomId);
		
		double oldPrice = r.getPrice().getValue();
		
		Price p = new Price();
		p.setStartDate(new Date());
		p.setEndDate(new Date());
		p.setValue(newValue);
		priceService.save(p);
		r.setPrice(p);
		roomService.save(r);
		
		
		Map<String, Object> data = new HashMap<>();
		data.put("hotel_id", String.valueOf(r.getHotel().getId()));
		fcmService.sendPushMessage(r.getName(),"Price changed from "+String.valueOf(oldPrice)+"€ to "+String.valueOf(p.getValue())+"€", "hotel_"+String.valueOf(r.getHotel().getId()), data, "new_room");
	}
	
}
