package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.data.entity.SmsSendingReport;
import com.service.booking.app.repository.SmsReportRepository;

@Service
@Transactional
public class SmsReportServiceImpl implements SmsReportService {

	@Autowired
	SmsReportRepository repository; 
	
	@Override
	public void save(SmsSendingReport smsReport) {
		repository.save(smsReport);
		
	}

	@Override
	public List<SmsSendingReport> findAll() {
		return repository.findAll();
	}

	@Override
	public List<SmsSendingReport> findSmsReportByBookingId(String bookingId) {
		return repository.findSmsSendingReportByBookingId(bookingId);
	}

	@Override
	public SmsSendingReport getSmsReportById(String id) {
		return repository.findSmsSendingReportById(id);
	}

}
