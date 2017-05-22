package com.tim11.pma.ftn.pmaprojekat.service;

import com.tim11.pma.ftn.pmaprojekat.model.Review;

import java.util.List;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
public interface ReviewService {

	Review create(Review review);

	List<Review> getReviewForUser(int userId);

	List<Review> getReservationsForFbProfile(String fbProfileId);

	List<Review> getReviewForHotel(int hotelId);
}
