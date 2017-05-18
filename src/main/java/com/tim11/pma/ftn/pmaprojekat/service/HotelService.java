package com.tim11.pma.ftn.pmaprojekat.service;

import java.util.List;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.viewmodel.SearchViewModel;

public interface HotelService {

	public List<Hotel> findAll();

	public void save(Hotel category);

	public void update(Hotel category);

	public void remove(Hotel categoryId);
	
	public List<Hotel> search(SearchViewModel searchViewModel);
}
