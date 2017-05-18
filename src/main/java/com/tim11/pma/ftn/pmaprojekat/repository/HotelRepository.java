package com.tim11.pma.ftn.pmaprojekat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.viewmodel.SearchViewModel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {
	
}
