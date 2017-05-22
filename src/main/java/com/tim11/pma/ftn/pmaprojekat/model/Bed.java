/***********************************************************************
 * Module:  Bed.java
 * Author:  Shuky
 * Purpose: Defines the Class Bed
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "bed")
public class Bed implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column
   private String name;

   @Column
   private String icon;

   @OneToMany(mappedBy = "bed")
   @JsonIgnore
   private Set<RoomBed> roomBeds;

   public Bed() {}

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

   public String getIcon() {
      return icon;
   }

   public void setIcon(String icon) {
      this.icon = icon;
   }

   public Set<RoomBed> getRoomBeds() {
      return roomBeds;
   }

   public void setRoomBeds(Set<RoomBed> roomBeds) {
      this.roomBeds = roomBeds;
   }
}