/***********************************************************************
 * Module:  Room.java
 * Author:  Shuky
 * Purpose: Defines the Class Room
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "room")
public class Room implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(nullable = false)
   private String name;

   @Column(nullable = false)
   private int count;

   @Column(nullable = false)
   private int available;

   @Column
   private String description;

   @OneToMany(mappedBy = "room")
   private Set<RoomBed> roomBeds;

   @ManyToMany(mappedBy = "rooms")
   private Set<Amenity> amenities;

   @OneToMany(mappedBy = "room")
   @JsonIgnore
   private Set<Reservation> reservations;

   @ManyToOne
   @JoinColumn(name = "hotel_id", referencedColumnName = "id")
   @JsonIgnore
   private Hotel hotel;

   @ManyToOne
   @JoinColumn(name = "price_id", referencedColumnName = "id")
   private Price price;

   public Room() {}

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

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public int getAvailable() {
      return available;
   }

   public void setAvailable(int available) {
      this.available = available;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Set<RoomBed> getRoomBeds() {
      return roomBeds;
   }

   public void setRoomBeds(Set<RoomBed> roomBeds) {
      this.roomBeds = roomBeds;
   }

   public Set<Amenity> getAmenities() {
      return amenities;
   }

   public void setAmenities(Set<Amenity> amenities) {
      this.amenities = amenities;
   }

   public Set<Reservation> getReservations() {
      return reservations;
   }

   public void setReservations(Set<Reservation> reservations) {
      this.reservations = reservations;
   }

   public Hotel getHotel() {
      return hotel;
   }

   public void setHotel(Hotel hotel) {
      this.hotel = hotel;
   }

   public Price getPrice() {
      return price;
   }

   public void setPrice(Price price) {
      this.price = price;
   }
}