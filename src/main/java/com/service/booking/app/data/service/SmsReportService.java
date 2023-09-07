package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.SmsSendingReport;

public interface SmsReportService {

	public void save(SmsSendingReport smsReport);
	public List<SmsSendingReport> findAll();
	public List<SmsSendingReport> findSmsReportByBookingId(String bookingId);
	public SmsSendingReport getSmsReportById(String id);
}
