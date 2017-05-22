/***********************************************************************
 * Module:  Reservation.java
 * Author:  Shuky
 * Purpose: Defines the Class Reservation
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(nullable = false)
   private Date startDate;

   @Column(nullable = false)
   private Date endDate;

   @Column(nullable = false)
   private double price;

   @ManyToOne
   @JoinColumn(name = "room_id", referencedColumnName = "id")
   private Room room;

   //TODO: Change to CascadeType.DETACH when user "registration" is implemented
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id", referencedColumnName = "id")
   private User user;

   public Reservation() {}

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

   public double getPrice() {
      return price;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public Room getRoom() {
      return room;
   }

   public void setRoom(Room room) {
      this.room = room;
   }

   public User getUser() {
      return user;
   }

   public void setUser(User user) {
      this.user = user;
   }
}