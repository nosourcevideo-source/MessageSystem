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
        try {
            // Sends OTP to the configured mobile number
            smsService.sendOtp(data);
            return "Appointment registered and OTP sent!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Appointment registered but failed to send OTP!";
        }
    }
}
