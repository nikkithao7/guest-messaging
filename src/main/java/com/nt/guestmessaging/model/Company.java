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
public class Company {
    
    private int id;
    private String company;
    private String city;
    private String timezone;

    public Company() {
        
    }
    
    public Company(int id, String company, String city, String timezone) {
        this.id = id;
        this.company = company;
        this.city = city;
        this.timezone = timezone;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getcompany() {
        return company;
    }

    public void setcompany(String company) {
        this.company = company;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                "company='" + company + '\'' +
                "city='" + city + '\'' +
                "timezone='" + timezone + '\'' + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.company);
        hash = 41 * hash + Objects.hashCode(this.city);
        hash = 41 * hash + Objects.hashCode(this.timezone);
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
        final Company other = (Company) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.company, other.company)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.timezone, other.timezone)) {
            return false;
        }
        return true;
    }
    
    
}
