package com.tim11.pma.ftn.pmaprojekat.repository;

import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	List<Review> findByUserId(int id);

	List<Review> findByHotelId(int id);

	List<Review> findByUser_fbUser_fbProfileId(String id);
}
