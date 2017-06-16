package com.tim11.pma.ftn.pmaprojekat.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim11.pma.ftn.pmaprojekat.dto.SearchViewModel;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Room;
import com.tim11.pma.ftn.pmaprojekat.repository.HotelRepository;
import com.tim11.pma.ftn.pmaprojekat.repository.RoomRepository;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Hotel> findAll() {
		return hotelRepository.findAll();
	}

	@Override
	public List<Hotel> findAllByIds(Integer... ids) {
		return hotelRepository.findAll(Arrays.asList(ids));
	}

	@Override
	public void save(Hotel category) {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void update(Hotel category) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void remove(Hotel categoryId) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not implemented");
	}

	@Override
	public List<Hotel> search(SearchViewModel searchViewModel) {

		List<Hotel> results =generateSearchQuery(searchViewModel).getResultList();
		return results;
	}

	private Query generateSearchQuery(SearchViewModel searchViewModel) {
		
		String query = "select distinct h " +
				"from Hotel h join h.rooms r join r.price p " +
				"where h.stars in :stars and h.rating >= :minRating and p.value <= :maxRoomPrice ";
		
		if(searchViewModel.getHotelName() != null && !searchViewModel.getHotelName().trim().isEmpty()){
			query += "and LOWER(h.name) like :hotelName ";
		}
		
		
		Query q = entityManager.createQuery(query)
		.setParameter("stars", searchViewModel.getStars())
		.setParameter("minRating", searchViewModel.getMinRating())
		.setParameter("maxRoomPrice", searchViewModel.getMaxRoomPrice());
		
		Set<Parameter<?>> params = q.getParameters();
		params.forEach(p -> {
			if(p.getName().equals("hotelName"))
				q.setParameter("hotelName", "%"+searchViewModel.getHotelName().toLowerCase()+"%");
		});
		
		return q;
	}

	@Override
	public Hotel addRoomToHotel(int hotelId, Room r) {

		Hotel h = hotelRepository.findOne(hotelId);
		h.getRooms().add(r);
		r.setHotel(h);
		roomRepository.save(r);
		return h;
		
	}

}
