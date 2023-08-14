package com.service.booking.app.data.service;

import java.time.LocalDate;
import java.util.List;

import com.service.booking.app.data.entity.BookingLimit;

public interface BookingLimitService {
	
	public List<BookingLimit> findBookingLimitByDatesAndLocatio(LocalDate date, LocalDate date1, LocalDate date2, LocalDate date3, Integer locationId);
}
