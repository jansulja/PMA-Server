package com.tim11.pma.ftn.pmaprojekat.controller;

import com.tim11.pma.ftn.pmaprojekat.dto.FbUserReviewDTO;
import com.tim11.pma.ftn.pmaprojekat.model.Hotel;
import com.tim11.pma.ftn.pmaprojekat.model.Reservation;
import com.tim11.pma.ftn.pmaprojekat.model.Review;
import com.tim11.pma.ftn.pmaprojekat.model.User;
import com.tim11.pma.ftn.pmaprojekat.repository.HotelRepository;
import com.tim11.pma.ftn.pmaprojekat.repository.ReservationRepository;
import com.tim11.pma.ftn.pmaprojekat.service.ReviewService;
import com.tim11.pma.ftn.pmaprojekat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ChogaraTheStrongest on 5/22/2017.
 */
@RestController
@RequestMapping("review")
public class ReviewController {

	@Autowired
	ReviewService reviewService;

	@Autowired
	UserService userService;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	HotelRepository hotelRepository;

	@RequestMapping(path = "/user/{userId}", method = RequestMethod.GET)
	public List<Review> getUserReviewList(@PathVariable int userId){
		List<Review> reviews = reviewService.getReviewForUser(userId);
		return reviews;
	}

	@RequestMapping(path = "/fbprofile/{fbProfileId}", method = RequestMethod.GET)
	public List<Review> getFbUserReviewList(@PathVariable String fbProfileId){
		List<Review> reviews = reviewService.getReservationsForFbProfile(fbProfileId);
		return reviews;
	}

	@RequestMapping(path = "/hotel/{hotelId}", method = RequestMethod.GET)
	public List<Review> getHotelReviewList(@PathVariable int userId){
		List<Review> reviews = reviewService.getReviewForUser(userId);
		return reviews;
	}

	@PostMapping
	public Review postFbUserReview(@RequestBody FbUserReviewDTO fbUserReviewDTO){
		Review review = new Review();
		User user = userService.findUserByFbProfileId(fbUserReviewDTO.getFbProfileId());
		review.setUser(user);
		Reservation reservation = reservationRepository.findOne(fbUserReviewDTO.getReservationId());
		review.setReservation(reservation);
		Hotel hotel = null;
		if (reservation != null){
			hotel = hotelRepository.findOne(reservation.getRoom().getHotel().getId());
		}
		review.setHotel(hotel);
		review.setDescription(fbUserReviewDTO.getDescription());
		review.setRating(fbUserReviewDTO.getRating());
		return reviewService.create(review);
	}
}
