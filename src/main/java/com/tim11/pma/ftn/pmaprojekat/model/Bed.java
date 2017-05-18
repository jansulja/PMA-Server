/***********************************************************************
 * Module:  Bed.java
 * Author:  Shuky
 * Purpose: Defines the Class Bed
 ***********************************************************************/

package com.tim11.pma.ftn.pmaprojekat.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/** @pdOid 5eb97ccc-9e45-46a3-ae93-825cdffd5621 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bed implements java.io.Serializable {
   /** @pdOid 70e946db-67cc-4393-9710-ccc043d05fb2 */
   private long bedId;
   /** @pdOid 45a0ad82-6e3e-4f92-8e65-8c9e34d45fcc */
   private java.lang.String name;
   /** @pdOid e6ba33cd-8e2b-4e36-a89c-e9f6d39564e5 */
   private java.lang.String icon;
   
   /** @pdRoleInfo migr=no name=Room assc=roomBed coll=java.util.Set impl=java.util.HashSet mult=0..* side=A */
   public java.util.Set<RoomBed> rooms;
   
   /**
    * Empty constructor which is required by Hibernate
    *
    */
   public Bed() {
      // TODO Auto-generated constructor stub
   }
   
   /**
    * @pdGenerated default getter
    */
   @JsonIgnore
   public java.util.Set<RoomBed> getRooms() {
      if (rooms == null)
         rooms = new java.util.HashSet<RoomBed>();
      return rooms;
   }
   
   /**
    * @pdGenerated default iterator getter
    */
   @JsonIgnore
   public java.util.Iterator getIteratorRooms() {
      if (rooms == null)
         rooms = new java.util.HashSet<RoomBed>();
      return rooms.iterator();
   }
   
   /** 
    * @pdGenerated default setter
    * @param newRooms
    */
   public void setRooms(java.util.Set<RoomBed> newRooms) {
      //removeAllRooms();
      this.rooms = newRooms;   
   }
   
   /** 
    * @pdGenerated default add
    * @param newRoom
    */
//   public void addRooms(RoomBed newRoom) {
//      if (newRoom == null)
//         return;
//      if (this.rooms == null)
//         this.rooms = new java.util.HashSet<RoomBed>();
//      if (!this.rooms.contains(newRoom))
//      {
//         this.rooms.add(newRoom);
//         newRoom.addBeds(this);
//      }
//   }
   
   /** 
    * @pdGenerated default remove
    * @param oldRoom
    */
   public void removeRooms(Room oldRoom) {
      if (oldRoom == null)
         return;
      if (this.rooms != null)
         if (this.rooms.contains(oldRoom))
         {
            this.rooms.remove(oldRoom);
            oldRoom.removeBeds(this);
         }
   }
   
   /**
    * @pdGenerated default removeAll
    */
   public void removeAllRooms() {
      if (rooms != null)
      {
         Room oldRoom;
         for (java.util.Iterator iter = getIteratorRooms(); iter.hasNext();)
         {
            oldRoom = (Room)iter.next();
            iter.remove();
            oldRoom.removeBeds(this);
         }
      }
   }
   
   /**
    * Get value of bedId
    *
    * @return bedId 
    */
   public long getBedId()
   {
      return bedId;
   }
   
   /**
    * Set value of bedId
    *
    * @param newBedId 
    */
   public void setBedId(long newBedId)
   {
      this.bedId = newBedId;
   }
   
   /**
    * Get value of name
    *
    * @return name 
    */
   public java.lang.String getName()
   {
      return name;
   }
   
   /**
    * Set value of name
    *
    * @param newName 
    */
   public void setName(java.lang.String newName)
   {
      this.name = newName;
   }
   
   /**
    * Get value of icon
    *
    * @return icon 
    */
   public java.lang.String getIcon()
   {
      return icon;
   }
   
   /**
    * Set value of icon
    *
    * @param newIcon 
    */
   public void setIcon(java.lang.String newIcon)
   {
      this.icon = newIcon;
   }
   

   
   /* (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   public boolean equals(Object other) {
   
      if (other == null)
         return false;
      
      if (other == this)
         return true;   
   
      if (!(other instanceof Bed))
         return false;
   
      Bed cast = (Bed) other;
   
      if (this.bedId != cast.getBedId())
         return false;
   
      if (this.name == null ? cast.getName() != this.name : !this.name.equals( cast.getName()))
         return false;
   
      if (this.icon == null ? cast.getIcon() != this.icon : !this.icon.equals( cast.getIcon()))
         return false;
   
      return true;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   public int hashCode() {
      int hashCode = 0;
      hashCode = 29 * hashCode + (new Long(bedId)).hashCode();
      if (this.name != null) 
         hashCode = 29 * hashCode + name.hashCode();
      if (this.icon != null) 
         hashCode = 29 * hashCode + icon.hashCode();
      return hashCode;
   }
   
   /* (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   public String toString()
   {
      StringBuffer ret = new StringBuffer();
      ret.append( "com.tim11.pma.ftn.pmaprojekat.model.Bed: " );
      ret.append( "bedId='" + bedId + "'");
      ret.append( "name='" + name + "'");
      ret.append( "icon='" + icon + "'");
      return ret.toString();
   }

}