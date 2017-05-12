package com.tim11.pma.ftn.pmaprojekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

}
