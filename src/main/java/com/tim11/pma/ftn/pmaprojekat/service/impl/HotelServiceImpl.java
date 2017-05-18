package com.tim11.pma.ftn.pmaprojekat.service.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Parameter;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.repository.HotelRepository;
import com.tim11.pma.ftn.pmaprojekat.service.HotelService;
import com.tim11.pma.ftn.pmaprojekat.viewmodel.SearchViewModel;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	
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

	@Override
	public List<Hotel> search(SearchViewModel searchViewModel) {

		List<Hotel> results =generateSearchQuery(searchViewModel).getResultList();
		return results;
		
	}

	private Query generateSearchQuery(SearchViewModel searchViewModel) {
		
		String query = "select distinct h from Hotel h join h.room r join r.price p where h.stars in :stars and h.rating >= :minRating and p.value <= :maxRoomPrice ";
		
		if(searchViewModel.getHotelName() != null && !searchViewModel.getHotelName().trim().isEmpty()){
			query += "and LOWER(h.name) like :hotelName ";
		}
		
		
		Query q = entityManager.createQuery(query)
		.setParameter("stars", searchViewModel.getStars())
		.setParameter("minRating", searchViewModel.getMinRating())
		.setParameter("maxRoomPrice", searchViewModel.getMaxRoomPrice());
		
		Set<Parameter<?>> params = q.getParameters();
		params.forEach(p-> {  if(p.getName().equals("hotelName")) q.setParameter("hotelName", "%"+searchViewModel.getHotelName().toLowerCase()+"%");  });
		
		return q;
	}

}
