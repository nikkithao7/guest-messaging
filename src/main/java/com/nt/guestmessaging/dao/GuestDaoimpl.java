/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nt.guestmessaging.model.Guest;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nthao
 */
@Repository
public class GuestDaoimpl implements GuestDao {

    private List<Guest> guestList = new ArrayList<>();
    
    @Override
    public List<Guest> getAllGuests() throws FileNotFoundException {
        Gson gson = new Gson();
    
        BufferedReader br = new BufferedReader(new FileReader("Guests.json"));
        Type type = new TypeToken<List<Guest>>(){}.getType();
        
        guestList = gson.fromJson(br, type);
        return guestList;
    }

    @Override
    public Guest getGuestById(int id) throws FileNotFoundException {
        getAllGuests();

        for (Guest g : guestList) {
            if (g.getId() == id) {
                return g;
            }
        }
        return null;
    }    
    
}

