/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.dao;

import com.nt.guestmessaging.model.Message;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author nthao
 */
public interface MessageDao {
    
    List<Message> getAllMessageTemplates() throws FileNotFoundException;

    Message getMessageTemplateById(int id, int companyId, int guestId) throws FileNotFoundException, EntityNotFoundException;

    Message createNewMessageTemplate(int id, String content) throws IOException;

}
