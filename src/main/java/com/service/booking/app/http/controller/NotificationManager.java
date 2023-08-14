package com.service.booking.app.http.controller;

import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.nimbusds.jose.shaded.gson.Gson;
import com.service.booking.app.request.EmailRequest;
import com.service.booking.app.response.EmailResponse;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.data.entity.EmailSendingReport;
import com.service.booking.app.data.service.EmailReportService;

public class NotificationManager {
	
	EmailReportService emailReportService;
	
	public NotificationManager(EmailReportService emailReportService) {	
		this.emailReportService = emailReportService;
	}
	
	public void sendEmailNotification(String to, String cc, String bcc, String subject, String body, Booking booking) {

		 try {
			 EmailRequest emailRequest = new EmailRequest(to, cc, bcc, subject, body);
			 
			// Convert the object to JSON
            String jsonRequestBody = new Gson().toJson(emailRequest);
            
            String response = makeHttpRequest("http://localhost:9090/notification/sendEmail", jsonRequestBody);
            
            EmailResponse emailResponse = new Gson().fromJson(response, EmailResponse.class);
            saveEmailReport(emailResponse, booking);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
	}
	
	public void sendHtmlEmailNotification(String to, String cc, String bcc, String subject, String htmlBody, Booking booking) {

		 try {
			 EmailRequest emailRequest = new EmailRequest(to, cc, bcc, subject, htmlBody);
			 
			// Convert the object to JSON
           String jsonRequestBody = new Gson().toJson(emailRequest);
           
           String response = makeHttpRequest("http://localhost:9090/notification/sendHtmlEmail", jsonRequestBody);
           
           EmailResponse emailResponse = new Gson().fromJson(response, EmailResponse.class);
           saveEmailReport(emailResponse, booking);
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("Error: " + e.getMessage());
       }
	}

	private String makeHttpRequest(String urlStr, String jsonRequestBody) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        
        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = jsonRequestBody.getBytes("utf-8");
            os.write(input, 0, input.length);
        }
        
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            throw new IOException("HTTP request failed with response code: " + responseCode);
        }
    }
	
	private void saveEmailReport(EmailResponse response, Booking booking) {
		EmailSendingReport report = new EmailSendingReport();
		report.setTo(response.getTo());
		report.setSubject(response.getSubject());
		report.setBody(response.getBody());
		report.setBooking(booking);
		report.setSendDateTime(response.getSendDateTime());
		report.setStatus(response.getStatus());
		report.setSuccess(response.isSuccess());
		report.setMessage(response.getMessage());
		
		try {
			emailReportService.save(report);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}




