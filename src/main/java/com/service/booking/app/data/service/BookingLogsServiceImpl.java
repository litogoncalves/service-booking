package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.data.entity.BookingLogs;
import com.service.booking.app.repository.BookingLogsRepository;

@Service
@Transactional
public class BookingLogsServiceImpl implements BookingLogsService{

	@Autowired
	BookingLogsRepository repository;
	
	@Override
	public void save(BookingLogs bookingLogs) {
		repository.save(bookingLogs);
	}

	@Override
	public List<BookingLogs> findAll() {
		return repository.findAll();
	}

	@Override
	public List<BookingLogs> findBookingLogsByBookingId(String bookingId) {
		return repository.findBookingLogsByBookingId(bookingId);
	}

	@Override
	public BookingLogs getBookingLogsByBookingLogsId(String bookingLogsId) {
		return repository.findBookingLogsByBookingLogsId(bookingLogsId);
	}


}
