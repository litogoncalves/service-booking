package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.EmailSendingReport;

public interface EmailReportService {
	
	public void save(EmailSendingReport emailReport);
	public List<EmailSendingReport> findAll();
	public List<EmailSendingReport> findEmailReportByBookingId(String bookingId);
	public EmailSendingReport getEmailReport(String familyId);
}
