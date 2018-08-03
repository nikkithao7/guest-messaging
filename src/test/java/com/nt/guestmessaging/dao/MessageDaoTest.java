/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.dao;

import com.nt.guestmessaging.model.Message;
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
public class MessageDaoTest {

    @Autowired
    MessageDao dao;

    List<Message> messageList = new ArrayList<>();
    Message message = new Message();

    public MessageDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        messageList = dao.getAllMessageTemplates();
        for (Message m : messageList) {
            dao.getAllMessageTemplates().remove(m);
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getAllMessageTemplates method, of class MessageDao.
     */
    @Test
    public void testGetAllMessageTemplates() throws Exception {
       messageList = dao.getAllMessageTemplates();
        assertEquals(4, messageList.size());
    }

    /**
     * Test of getMessageTemplateById method, of class MessageDao.
     */
    @Test
    public void testGetMessageTemplateById() throws Exception {
        Message messageFromDao = dao.getMessageTemplateById(1, 1, 1);

        assertEquals("Good", messageFromDao.getContent().subSequence(0, 4));
        assertEquals("Candy", messageFromDao.getContent().subSequence(13, 18));
        assertEquals("Hotel California", messageFromDao.getContent().subSequence(35, 51));
    }

    /**
     * Test of createNewMessageTemplate method, of class MessageDao.
     */
    @Test
    public void testCreateNewMessageTemplate() throws Exception {
        message = dao.createNewMessageTemplate(4, "Hello there #guestName!");
        
        messageList = dao.getAllMessageTemplates();
        
        assertEquals(4, message.getId());
    }

}
