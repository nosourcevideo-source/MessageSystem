package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Service
public class SMSService {

    @Value("${twofactor_api_key}")
    private String apiKey;

    @Value("${mobile_to}")
    private String defaultMobile;

    /**
     * Sends OTP via SMS using 2Factor AUTOGEN API.
     * Accepts form data from frontend but only logs it.
     */
    public String sendOtp(Map<String, String> data) {
        try {
            System.out.println("Received Form Data: " + data);

            // IMPORTANT: SMS endpoint (NOT voice)
            String urlString = "https://2factor.in/API/V1/"
                    + apiKey
                    + "/SMS/"
                    + defaultMobile
                    + "/AUTOGEN";

            System.out.println("Final OTP URL: " + urlString);

            // Create connection
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // Read response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );

            StringBuilder response = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                response.append(line);
            }

            br.close();

            System.out.println("OTP Response: " + response);
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error sending OTP: " + e.getMessage();
        }
    }
}
