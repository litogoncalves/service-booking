package com.service.booking.app.http.controller;

import java.io.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.time.LocalDateTime;
import java.net.URL;
import java.util.Map;
import java.util.HashMap;


import com.service.booking.app.request.EmailRequest;
import com.service.booking.app.request.SmsRequest;
import com.service.booking.app.response.EmailResponse;
import com.service.booking.app.response.SmsResponse;
import com.service.booking.app.utils.Utils;
import com.nimbusds.jose.shaded.gson.Gson;
import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.data.entity.EmailSendingReport;
import com.service.booking.app.data.service.EmailReportService;
import com.service.booking.app.data.entity.SmsSendingReport;
import com.service.booking.app.data.service.SmsReportService;

public class NotificationManager {
	
	private static final String ENDPOINT_SMS = "https://api.usendit.co.mz/v2/remoteusendit.asmx/SendMessage?username={user}&password={pass}&partnerEventId=&timezone=&partnerMsgId=&sender={sender}&msisdn={contact}&mobileOperator={mobileOperator}&priority=0&expirationDatetime=&messageText={message}&scheduleDatetime=&beginTime=&endTime=&workingDays=false&isFlash=false";
	private static final String GET_METHOD = "GET";
	private static final String POST_METHOD = "POST";
	
	Map<String, Integer> operators;
	
	EmailReportService emailReportService;
	SmsReportService smsReportService;
	
	public NotificationManager(EmailReportService emailReportService, SmsReportService smsReportService) {	
		this.emailReportService = emailReportService;
		this.smsReportService = smsReportService;
	}
	
	public void sendEmailNotification(String to, String cc, String bcc, String subject, String body, Booking booking) {

		 try {
			 EmailRequest emailRequest = new EmailRequest(to, cc, bcc, subject, body);
			 
			// Convert the object to JSON
            String jsonRequestBody = new Gson().toJson(emailRequest);
            
            String response = makeHttpRequest("http://localhost:9090/notification/sendEmail", jsonRequestBody, POST_METHOD);
            
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
           
           String response = makeHttpRequest("http://localhost:9090/notification/sendHtmlEmail", jsonRequestBody, "POST");
           
           EmailResponse emailResponse = new Gson().fromJson(response, EmailResponse.class);
           saveEmailReport(emailResponse, booking);
       } catch (IOException e) {
           e.printStackTrace();
           System.out.println("Error: " + e.getMessage());
       }
	}
	
	public void sendSMSBookingNotification(Booking booking, String message) {
		try {
			sendSMSNotification(booking, message);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	private String makeHttpRequest(String urlStr, String jsonRequestBody, String method) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(method);
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
	
	private void saveSmsReport(SmsResponse response, String sendTo, String messsageText, Booking booking) {
		SmsSendingReport report = new SmsSendingReport();
		report.setSendTo(sendTo);
		report.setBooking(booking);
		report.setMessageText(messsageText);
		report.setSendDateTime(LocalDateTime.now().toString());
		report.setStatus(response.getStatus());
		report.setSuccess(response.isSuccess());
		report.setMessage(response.getMessage());
		report.setUsenditResponse(response.getUsenditResponse());
		
		try {
			smsReportService.save(report);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//To Use for SMS Notifications
	public void sendSMSNotification(Booking booking, String messageText) {

		 try {
			 SmsRequest smsRequest = setSmsRequestValues(booking, messageText);			 
			 
			// Convert the object to JSON
          String jsonRequestBody = new Gson().toJson(smsRequest);
          
          String response = makeHttpRequest("http://localhost:9090/notification/sendSMS", jsonRequestBody, "POST");
          
          SmsResponse smsResponse = new Gson().fromJson(response, SmsResponse.class);
          saveSmsReport(smsResponse, smsRequest.getSendTo(), smsRequest.getMessageText(), booking);
      } catch (IOException e) {
          e.printStackTrace();
          System.out.println("Error: " + e.getMessage());
      }
	}
	
	//To Working
	private void sendSMS(String countryCode, String sendTo, String message) {
		String request = ENDPOINT_SMS;
		String mobileOperator = operators.get(sendTo.substring(0, 2)) != null ? operators.get(sendTo.substring(0, 2)).toString() : "0";
		
		request = request.replace("{user}", Constants.getUsenditUsername()).replace("{pass}", Constants.getUsenditPassword()).replace("{sender}", "")
				.replace("{contact}", countryCode.concat(sendTo)).replace("{message}", message).replace("{mobileOperator}", mobileOperator);
		
		try {
			String jsonRequestBody = new Gson().toJson("");
			String response = makeHttpRequest(request, jsonRequestBody, GET_METHOD);
			System.out.println(response);
		} catch (IOException e) {
			e.printStackTrace();
	        System.out.println("Error: " + e.getMessage());
		}
	}
	
	private SmsRequest setSmsRequestValues(Booking booking, String messageText) {
		SmsRequest smsRequest = new SmsRequest();
		String contact = "";
		String mobileOperator = "";
		operators = getOperatorsMap();
		
		if(booking.getCountryCode() != null && booking.getPhoneNumberReq() != null) {
			
			mobileOperator = operators.get(booking.getPhoneNumberReq().trim().substring(0, 2)) != null ? operators.get(booking.getPhoneNumberReq().trim().substring(0, 2)).toString() : "0";
			String contactCountryCode = Utils.keepNumbersOnly(booking.getCountryCode().getName());
			contact = contactCountryCode.trim().concat(booking.getPhoneNumberReq().trim());
		}
			
		smsRequest.setUsername(Constants.getUsenditUsername());
		smsRequest.setPassword(Constants.getUsenditPassword());
		smsRequest.setPartnerEventId("");
		smsRequest.setTimezone("");
		smsRequest.setPartnerMsgId("");
		smsRequest.setSender("");
		smsRequest.setSendTo(contact);
		smsRequest.setMobileOperator(mobileOperator);
		smsRequest.setPriority(0);
		smsRequest.setExpirationDatetime("");
		smsRequest.setMessageText(messageText);
		smsRequest.setScheduleDatetime("");
		smsRequest.setBeginTime("");
		smsRequest.setEndTime("");
		smsRequest.setWorkingDays(false);
		smsRequest.setFlash(false);
		
		return smsRequest;
    }
	
	private Map<String, Integer> getOperatorsMap() {

		operators = new HashMap<>();
		operators.put("86", 21);
		operators.put("87", 21);
		operators.put("84", 22);
		operators.put("85", 22);
		operators.put("82", 23);
		operators.put("83", 23);
		
		return operators;
	}
}




