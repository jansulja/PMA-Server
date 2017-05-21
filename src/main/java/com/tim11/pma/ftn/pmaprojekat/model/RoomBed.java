/***********************************************************************
 * Module:  RoomBed.java
 * Author:  Shuky
 * Purpose: Defines the Class RoomBed
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "room_bed")
public class RoomBed implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(nullable = false)
   private int count;

   @ManyToOne
   @JoinColumn(name = "room_id", referencedColumnName = "id")
   @JsonIgnore
   private Room room;

   @ManyToOne
   @JoinColumn(name = "bed_id", referencedColumnName = "id")
   private Bed bed;

   public RoomBed() {}

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public int getCount() {
      return count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public Room getRoom() {
      return room;
   }

   public void setRoom(Room room) {
      this.room = room;
   }

   public Bed getBed() {
      return bed;
   }

   public void setBed(Bed bed) {
      this.bed = bed;
   }
}