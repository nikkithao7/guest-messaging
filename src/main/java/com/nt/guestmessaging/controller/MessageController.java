/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.controller;

import com.nt.guestmessaging.dao.EntityNotFoundException;
import com.nt.guestmessaging.dao.MessageDao;
import com.nt.guestmessaging.model.Message;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nthao
 */
@RestController
public class MessageController {

    @Autowired
    MessageDao messageDao;

    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public List<Message> displayMessages() throws FileNotFoundException {
        return messageDao.getAllMessageTemplates();
    }

    @RequestMapping(value = "/message/{id}/company/{companyId}/guest/{guestId}", method = RequestMethod.GET)
    public Message displayFullMessageById(@PathVariable("id") int id, @PathVariable("companyId") int companyId,
            @PathVariable("guestId") int guestId) throws FileNotFoundException, EntityNotFoundException {
        Message message = messageDao.getMessageTemplateById(id, companyId, guestId);

        if (message == null) {
            throw new EntityNotFoundException("Message id " + id + " does not exist. Please enter a valid message id.");
        }

        return message;
    }

    @RequestMapping(value = "/message", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Message createNewMessage(@RequestBody Message message) throws IOException {
        int id = message.getId();
        String content = message.getContent();

        return messageDao.createNewMessageTemplate(id, content);
    }
    
}
