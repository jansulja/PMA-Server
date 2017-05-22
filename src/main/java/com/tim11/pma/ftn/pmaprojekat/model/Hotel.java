/***********************************************************************
 * Module:  Hotel.java
 * Author:  Shuky
 * Purpose: Defines the Class Hotel
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "hotel")
public class Hotel implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(nullable = false)
   private String name;

   @Column
   private String description;

   @Column
   private String website;

   @Column
   private String phone;

   @Column
   private int stars;

   @Column
   private double rating;

   @Column
   private int numberOfReviews;

   @Column
   private String imageFilename;

   @ManyToMany(mappedBy = "hotels")
   private Set<Amenity> amenities;

   @OneToMany(mappedBy = "hotel")
   private Set<Review> reviews;

   @OneToMany(mappedBy = "hotel")
   private Set<Room> rooms;

   @ManyToOne
   @JoinColumn(name = "address_id", referencedColumnName = "id")
   private Address address;

   public Hotel() {}

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public String getWebsite() {
      return website;
   }

   public void setWebsite(String website) {
      this.website = website;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public int getStars() {
      return stars;
   }

   public void setStars(int stars) {
      this.stars = stars;
   }

   public double getRating() {
      return rating;
   }

   public void setRating(double rating) {
      this.rating = rating;
   }

   public int getNumberOfReviews() {
      return numberOfReviews;
   }

   public void setNumberOfReviews(int numberOfReviews) {
      this.numberOfReviews = numberOfReviews;
   }

   public String getImageFilename() {
      return imageFilename;
   }

   public void setImageFilename(String imageFilename) {
      this.imageFilename = imageFilename;
   }

   public Set<Amenity> getAmenities() {
      return amenities;
   }

   public void setAmenities(Set<Amenity> amenities) {
      this.amenities = amenities;
   }

   public Set<Review> getReviews() {
      return reviews;
   }

   public void setReviews(Set<Review> reviews) {
      this.reviews = reviews;
   }

   public Set<Room> getRooms() {
      return rooms;
   }

   public void setRooms(Set<Room> rooms) {
      this.rooms = rooms;
   }

   public Address getAddress() {
      return address;
   }

   public void setAddress(Address address) {
      this.address = address;
   }
}