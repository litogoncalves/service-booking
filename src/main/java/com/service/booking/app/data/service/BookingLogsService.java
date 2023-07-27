package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.BookingLogs;

public interface BookingLogsService {

	public void save(BookingLogs bookingLogs);
	public List<BookingLogs> findAll();
	public List<BookingLogs> findBookingLogsByBookingId(String bookingId);
	public BookingLogs getBookingLogsByBookingLogsId(String bookingLogsId);
	
}
