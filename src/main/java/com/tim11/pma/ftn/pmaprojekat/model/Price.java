/***********************************************************************
 * Module:  Price.java
 * Author:  Shuky
 * Purpose: Defines the Class Price
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "price")
public class Price implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column
   private Date startDate;

   @Column
   private Date endDate;

   @Column(nullable = false)
   private double value;

   @OneToMany(mappedBy = "price")
   @JsonIgnore
   private Set<Room> rooms;

   public Price() {}

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public Date getStartDate() {
      return startDate;
   }

   public void setStartDate(Date startDate) {
      this.startDate = startDate;
   }

   public Date getEndDate() {
      return endDate;
   }

   public void setEndDate(Date endDate) {
      this.endDate = endDate;
   }

   public double getValue() {
      return value;
   }

   public void setValue(double value) {
      this.value = value;
   }

   public Set<Room> getRooms() {
      return rooms;
   }

   public void setRooms(Set<Room> rooms) {
      this.rooms = rooms;
   }
}