/***********************************************************************
 * Module:  Address.java
 * Author:  Shuky
 * Purpose: Defines the Class Address
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;

   @Column(nullable = false)
   private String street;

   @Column
   private String number;

   @Column(nullable = false)
   private String city;

   @Column(nullable = false)
   private String country;

   @Column
   private double latitude;

   @Column
   private double longitude;

   @OneToMany(mappedBy = "address")
   @JsonIgnore
   private Set<Hotel> hotels;

   @OneToMany(mappedBy = "address")
   @JsonIgnore
   private Set<User> users;

   private Address() {}

   private long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getNumber() {
      return number;
   }

   public void setNumber(String number) {
      this.number = number;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public double getLatitude() {
      return latitude;
   }

   public void setLatitude(double latitude) {
      this.latitude = latitude;
   }

   public double getLongitude() {
      return longitude;
   }

   public void setLongitude(double longitude) {
      this.longitude = longitude;
   }

   public Set<Hotel> getHotels() {
      return hotels;
   }

   public void setHotels(Set<Hotel> hotels) {
      this.hotels = hotels;
   }

   public Set<User> getUsers() {
      return users;
   }

   public void setUsers(Set<User> users) {
      this.users = users;
   }
}