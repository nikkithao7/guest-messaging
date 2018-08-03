/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.dao;

import com.nt.guestmessaging.model.Guest;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author nthao
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class GuestDaoTest {

    @Autowired
    GuestDao dao;

    List<Guest> guestList = new ArrayList<>();

    public GuestDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        guestList = dao.getAllGuests();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllGuests method, of class GuestDao.
     */
    @Test
    public void testGetAllGuests() throws Exception {
        assertEquals(6, guestList.size());
    }

    /**
     * Test of getGuestById method, of class GuestDao.
     */
    @Test
    public void testGetGuestById() throws Exception {
        Guest guest = dao.getGuestById(1);
        
        assertEquals("Candy", guest.getFirstName());
    }

}
