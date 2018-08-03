/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.model;

import java.util.Objects;

/**
 *
 * @author nthao
 */
public class Reservation {
    
    private int roomNumber;
    private long startTimestamp;
    private long endTimestamp;

    public Reservation() {

    }

    public Reservation(int roomNumber, long startTimestamp, long endTimestamp) {
        this.roomNumber = roomNumber;
        this.startTimestamp = startTimestamp;
        this.endTimestamp = endTimestamp;
    }
    
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public long getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(long startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public long getEndTimestamp() {
        return endTimestamp;
    }

    public void setEndTimestamp(long endTimestamp) {
        this.endTimestamp = endTimestamp;
    }

        @Override
    public String toString() {
        return "Reservation{"
                + "roomNumber='" + roomNumber + '\''
                + "startTimestamp='" + startTimestamp + '\''
                + "endTimestamp='" + endTimestamp + '\'' + '}';
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.roomNumber;
        hash = 59 * hash + Objects.hashCode(this.startTimestamp);
        hash = 59 * hash + Objects.hashCode(this.endTimestamp);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Reservation other = (Reservation) obj;
        if (this.roomNumber != other.roomNumber) {
            return false;
        }
        if (this.startTimestamp != other.startTimestamp) {
            return false;
        }
        if (this.endTimestamp != other.endTimestamp) {
            return false;
        }
        return true;
    }
    
    
}
