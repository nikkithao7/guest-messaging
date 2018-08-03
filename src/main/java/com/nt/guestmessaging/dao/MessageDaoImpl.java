/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nt.guestmessaging.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.nt.guestmessaging.model.Company;
import com.nt.guestmessaging.model.Guest;
import com.nt.guestmessaging.model.Message;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nthao
 */
@Repository
public class MessageDaoImpl implements MessageDao {

    @Autowired
    CompanyDao companyDao;
    @Autowired
    GuestDao guestDao;

    private List<Message> messageList = new ArrayList<>();

    @Override
    public List<Message> getAllMessageTemplates() throws FileNotFoundException {
        Gson gson = new Gson();

        BufferedReader br = new BufferedReader(new FileReader("Messages.json"));
        Type type = new TypeToken<List<Message>>() {
        }.getType();
        messageList = gson.fromJson(br, type);
        return messageList;
    }

    @Override
    public Message getMessageTemplateById(int id, int companyId, int guestId) throws FileNotFoundException, EntityNotFoundException {
        Gson gson = new Gson();
        Company c = companyDao.getCompanyById(companyId);
        if (c == null) {
            throw new EntityNotFoundException("Company id " + companyId + " does not exist. Please enter a valid company id.");
        }

        Guest g = guestDao.getGuestById(guestId);
        if (g == null) {
            throw new EntityNotFoundException("Guest id " + guestId + " does not exist. Please enter a valid guest id.");
        }

        getAllMessageTemplates();

        for (Message m : messageList) {
            if (m.getId() == id) {
                String content = m.getContent();

                //Get reservation start time & replace #reservationStartTime placeholder in JSON template
                String timezone = c.getTimezone();
                long tzConverter = 0;

                //Hours turned into milliseconds to determine timezones of hotel location
                if (timezone.equalsIgnoreCase("US/Pacific")) {
                    tzConverter = 25200000;
                } else if (timezone.equalsIgnoreCase("US/Central")) {
                    tzConverter = 18000000;
                } else if (timezone.equalsIgnoreCase("US/Eastern")) {
                    tzConverter = 14400000;
                }

                long startTime = g.getreservation().getStartTimestamp();
                startTime = (startTime - tzConverter);
                Date date = new Date(startTime * 1000);
                String dateToString = date.toString();
                int time = Integer.parseInt(dateToString.substring(11, 13));
                String reservationStartTime = "";

                if (time < 12) {
                    reservationStartTime = "morning";
                } else if ((time >= 12) && (time < 18)) {
                    reservationStartTime = "afternoon";
                } else if (time >= 18) {
                    reservationStartTime = "evening";
                }

                content = content.replaceAll("#reservationStartTime", reservationStartTime);

                //Replace #guestName placeholder in JSON template
                String guestName = g.getFirstName();
                content = content.replaceAll("#guestName", guestName);

                //Replace #companyName placeholder in JSON template
                String companyName = c.getcompany();
                content = content.replaceAll("#companyName", companyName);

                //Replace #roomNumber placeholder in JSON template
                String roomNumber = Integer.toString(g.getreservation().getRoomNumber());
                content = content.replaceAll("#roomNumber", roomNumber);

                //Get reservation end time & replace #reservationEndTime placeholder in JSON template
                long endTime = g.getreservation().getEndTimestamp();
                endTime = (endTime - tzConverter);
                Date endDate = new Date(endTime * 1000);
                String endDateToString = endDate.toString();
                int endTimeInt = Integer.parseInt(endDateToString.substring(11, 13));
                String reservationEndTime = "";

                if (endTimeInt < 12) {
                    reservationEndTime = "Have a great rest of your day";
                } else if ((endTimeInt >= 12) && (time < 18)) {
                    reservationEndTime = "Have a wonderful afternoon";
                } else if (endTimeInt >= 18) {
                    reservationEndTime = "Have a good night";
                }

                content = content.replaceAll("#reservationEndTime", reservationEndTime);

                m.setContent(content);

                return m;
            }
        }
        return null;
    }

    @Override
    public Message createNewMessageTemplate(int id, String content) throws IOException {
        getAllMessageTemplates();

        for (Message m : messageList) {
            if (m.getId() == id) {
                throw new IOException("Message with the id " + id + " already exists. Please choose another id.");
            } else if (id == 0) {
                throw new IOException("Please choose an id greater than 0.");
            }
        }

        Message message = new Message();
        message.setId(id);
        message.setContent(content);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        messageList.add(message);
        String jsonString = gson.toJson(messageList);

        FileWriter fw = new FileWriter("Messages.json");
        fw.write(jsonString);
        fw.close();

        return message;

    }

}
