package com.tim11.pma.ftn.pmaprojekat.service.impl;

import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Review;
import com.tim11.pma.ftn.pmaprojekat.repository.HotelRepository;
import com.tim11.pma.ftn.pmaprojekat.repository.ReviewRepository;
import com.tim11.pma.ftn.pmaprojekat.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	HotelRepository hotelRepository;

	@Override
	@Transactional
	public Review create(Review review) {
		if (review == null
				|| review.getUser() == null
				|| review.getHotel() == null) {
			return null;
		} else {
			Review newReview = reviewRepository.save(review);
			Hotel hotel = newReview.getHotel();
			hotel.setNumberOfReviews(hotel.getNumberOfReviews() + 1);
			hotelRepository.save(hotel);
			return newReview;
		}
	}

	@Override
	public List<Review> getReviewForUser(int userId) {
		return reviewRepository.findByUserId(userId);
	}

	@Override
	public List<Review> getReservationsForFbProfile(String fbProfileId) {
		return reviewRepository.findByUser_fbUser_fbProfileId(fbProfileId);
	}

	@Override
	public List<Review> getReviewForHotel(int hotelId) {
		return reviewRepository.findByHotelId(hotelId);
	}
}
