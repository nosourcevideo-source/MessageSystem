package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class SMSService {

    @Value("${twofactor_api_key}")
    private String apiKey;

    @Value("${mobile_to}")
    private String mobileTo;

    public void sendSMS(Map<String, String> data) throws Exception {

        String message = "Appointment Details:\n" +
                "Name: " + data.get("name") + "\n" +
                "Age: " + data.get("age") + "\n" +
                "Time: " + data.get("time") + "\n" +
                "Place: " + data.get("place");

        String encodedMessage = URLEncoder.encode(message, StandardCharsets.UTF_8.toString());

        System.out.println("Message to send: " + encodedMessage);

        // Here you will call the actual 2Factor API
        // Just printing for now
        System.out.println("API KEY: " + apiKey);
        System.out.println("Sending SMS to: " + mobileTo);
    }
}