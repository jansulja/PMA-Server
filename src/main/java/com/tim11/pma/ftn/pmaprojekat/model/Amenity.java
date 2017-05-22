/***********************************************************************
 * Module:  Amenity.java
 * Author:  Shuky
 * Purpose: Defines the Class Amenity
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "amenity")
public class Amenity implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column
   private String name;

   @Column
   private String description;

   @Column
   private String icon;

   @ManyToMany
   @JoinTable(name = "hotel_amenities", joinColumns = {
           @JoinColumn(name = "amenity_id", nullable = false, updatable = false) },
           inverseJoinColumns = { @JoinColumn(name = "hotel_id", nullable = false, updatable = false) })
   @JsonIgnore
   private Set<Hotel> hotels;

   @ManyToMany
   @JoinTable(name = "room_amenities", joinColumns = {
           @JoinColumn(name = "amenity_id", nullable = false, updatable = false) },
           inverseJoinColumns = { @JoinColumn(name = "room_id", nullable = false, updatable = false) })
   @JsonIgnore
   private Set<Room> rooms;

   public Amenity() {}

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

   public String getIcon() {
      return icon;
   }

   public void setIcon(String icon) {
      this.icon = icon;
   }

   public Set<Hotel> getHotels() {
      return hotels;
   }

   public void setHotels(Set<Hotel> hotels) {
      this.hotels = hotels;
   }

   public Set<Room> getRooms() {
      return rooms;
   }

   public void setRooms(Set<Room> rooms) {
      this.rooms = rooms;
   }
}