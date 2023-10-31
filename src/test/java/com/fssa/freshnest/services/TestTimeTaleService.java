package com.fssa.freshnest.services;

import com.fssa.freshnest.model.RequestAndResponse;
import com.fssa.freshnest.model.TimeTales;
import com.fssa.freshnest.services.exceptions.ServiceException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTimeTaleService {

    @Test
    void testCreateTimeTale() {
        int userId = 1;
        String mediaUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRCIq1WFIqckI69eGZ67ugLdfxchy96eLR7w&usqp=CAU";
        double duration = 12.3;
        TimeTalesService timeTalesService = new TimeTalesService();
        TimeTales timeTales = new TimeTales();
        timeTales.setMedia_url(mediaUrl);
        timeTales.setTaleDuration(duration);
        timeTales.setUserId(userId);

        try {
            assertTrue((timeTalesService.createTimeTale(timeTales)));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void testTimeTaleDeleteSuccess() {
        int taleId = 3;
        TimeTalesService timeTalesService = new TimeTalesService();
        TimeTales timeTale = new TimeTales();
        timeTale.setTaleId(taleId);

        try {
            assertTrue(timeTalesService.deleteTimeTalesByTaleId(timeTale));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }


    @Test
    void testGetUserTimeTales() {
        int userId = 1;
        TimeTalesService timeTalesService = new TimeTalesService();
        TimeTales timeTales = new TimeTales();
        timeTales.setUserId(userId);

        try {
            List<TimeTales> timeTaleList = timeTalesService.listUserTimeTales(timeTales);
            assertNotNull(timeTaleList);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testTimeTaleChatMessageSend() {
        String message = "Hello machi";
        int taleId = 1;
        int userId = 1;
        int receiverId = 2;

        NotificationService notificationService = new NotificationService();

        RequestAndResponse requestAndResponse = new RequestAndResponse();
        requestAndResponse.setRequestType("tale_reaction");
        requestAndResponse.setRequestSenderId(userId);
        requestAndResponse.setRequestReceiverId(receiverId);
        requestAndResponse.setRequestText(message);

        try {
            assertTrue(notificationService.sendTimeTaleMessage(requestAndResponse));
        } catch (ServiceException e) {
            e.printStackTrace();
            fail();
        }
    }
}
