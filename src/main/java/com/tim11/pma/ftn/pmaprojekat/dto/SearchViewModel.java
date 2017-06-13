package com.tim11.pma.ftn.pmaprojekat.dto;

import java.util.List;

public class SearchViewModel {
	
	private List<Integer> stars;
	private double minRating;
	private double maxRoomPrice;
	private String hotelName;
	
	

	public double getMinRating() {
		return minRating;
	}

	public void setMinRating(double minRating) {
		this.minRating = minRating;
	}

	public double getMaxRoomPrice() {
		return maxRoomPrice;
	}

	public void setMaxRoomPrice(double maxRoomPrice) {
		this.maxRoomPrice = maxRoomPrice;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public List<Integer> getStars() {
		return stars;
	}

	public void setStars(List<Integer> stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "SearchViewModel{" +
				"stars=" + stars +
				", minRating=" + minRating +
				", maxRoomPrice=" + maxRoomPrice +
				", hotelName='" + hotelName + '\'' +
				'}';
	}
}
