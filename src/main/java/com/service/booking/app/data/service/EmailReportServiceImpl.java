package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.data.entity.EmailSendingReport;
import com.service.booking.app.repository.EmailReportRepository;

@Service
@Transactional
public class EmailReportServiceImpl implements EmailReportService {

	@Autowired
	EmailReportRepository repository;
	
	@Override
	public void save(EmailSendingReport emailReport) {
		repository.save(emailReport);
	}

	@Override
	public List<EmailSendingReport> findAll() {
		return repository.findAll();
	}

	@Override
	public List<EmailSendingReport> findEmailReportByBookingId(String bookingId) {
		return repository.findEmailSendingReportByBookingId(bookingId);
	}

	@Override
	public EmailSendingReport getEmailReport(String emailReportId) {
		return repository.findEmailSendingReportById(emailReportId);
	}

}
