package com.example.mail_sender.service;

import com.example.mail_sender.email.MailOrderAsked;
import com.example.mail_sender.infra.db.IOrderRepository;
import org.springframework.mail.MailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.concurrent.ExecutionException;

@Service
public class ScheduleService {

    private final IOrderService service;

    private final MailOrderAsked mailOrderAsked;

    public ScheduleService(IOrderService service, MailOrderAsked mailOrderAsked) {
        this.service = service;
        this.mailOrderAsked = mailOrderAsked;
    }

    @Scheduled(cron = "0 10 12 * * *")
    public void getReportAndSendEmail(){
        var date = LocalDate.now();
        var report = service.getReport(date);

        try {
            mailOrderAsked.send(report.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Report was sent.");
    }
}
