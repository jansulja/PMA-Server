package com.tim11.pma.ftn.pmaprojekat.service;

import java.util.List;

import com.tim11.pma.ftn.pmaprojekat.dto.SearchViewModel;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;

public interface HotelService {

	public List<Hotel> findAll();

	public List<Hotel> findAllByIds(Integer... ids);

	public void save(Hotel hotel);

	public void update(Hotel hotel);

	public void remove(Hotel hotel);
	
	public List<Hotel> search(SearchViewModel searchViewModel);
	
	public Hotel addRoomToHotel(int hotelId,Room r);
}
