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
public class Guest {

    private int id;
    private String firstName;
    private String lastName;
    private Reservation reservation;

    public Guest() {

    }

    public Guest(int id, String firstName, String lastName, Reservation reservation) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.reservation = reservation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Reservation getreservation() {
        return reservation;
    }

    public void setreservation(Reservation reservation) {
        this.reservation = reservation;
    }

    @Override
    public String toString() {
        return "Guest{"
                + "id='" + id + '\''
                + "firstName='" + firstName + '\''
                + "lastName='" + lastName + '\''
                + "reservation='" + reservation + '\'' + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.id;
        hash = 37 * hash + Objects.hashCode(this.firstName);
        hash = 37 * hash + Objects.hashCode(this.lastName);
        hash = 37 * hash + Objects.hashCode(this.reservation);
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
        final Guest other = (Guest) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.reservation, other.reservation)) {
            return false;
        }
        return true;
    }

}
