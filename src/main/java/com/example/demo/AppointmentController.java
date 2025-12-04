package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AppointmentController {

    @Autowired
    private SMSService smsService;

    @PostMapping("/register")
    public String register(@RequestBody Map<String, String> data) {

        System.out.println("Received appointment data: " + data);

        try {
            smsService.sendSMS(data);
            return "Appointment registered and SMS sent!";
        } catch (Exception e) {
            System.out.println("Error sending SMS: " + e.getMessage());
            return "Appointment registered but failed to send SMS!";
        }
    }
}