package com.service.booking.app.data.service;

import com.service.booking.app.constants.GlobalProperties;


public class EmailService {

	private static final String SMTP_HOST = "smtp.gmail.com";
	private static final String USERNAME = "elexrafael@gmail.com";
	private static final String PASSWORD = GlobalProperties.getMailPassword();
	private static final int SMTP_PORT = 587; // For TLS For SSL, use port 465
	
	//private Properties props = new Properties();
	
	public EmailService() {
		//props = new GlobalProperties();
	}
}
