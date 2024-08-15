package com.example.mail_sender.email;

import com.example.mail_sender.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class MailOrderAsked {

    @Autowired
    private MailOrderSender mailSender;

    @Async
    public void send(BigDecimal value){
        mailSender.sendSimpleMail(
                "luccaaraujoberaldo456@gmail.com",
                "Order required with success!",
                "Hello! " + "\n\nIt's your daily report" +
                "\n\nAmount: " + "\n" + value);
    }
}
