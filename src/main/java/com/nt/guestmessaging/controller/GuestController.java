/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.controller;

import com.nt.guestmessaging.dao.EntityNotFoundException;
import com.nt.guestmessaging.dao.GuestDao;
import com.nt.guestmessaging.model.Guest;
import java.io.FileNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nthao
 */
@RestController
public class GuestController {

    @Autowired
    GuestDao guestDao;

    @RequestMapping(value = "/guests", method = RequestMethod.GET)
    public List<Guest> displayGuests() throws FileNotFoundException {
        return guestDao.getAllGuests();
    }

    @RequestMapping(value = "/guest/{id}", method = RequestMethod.GET)
    public Guest displayGuestById(@PathVariable("id") int id) throws FileNotFoundException, EntityNotFoundException {
        Guest guest = guestDao.getGuestById(id);

        if (guest == null) {
            throw new EntityNotFoundException("Guest id " + id + " does not exist. Please enter a valid guest id.");
        }

        return guest;
    }
    
}
