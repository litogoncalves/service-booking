package com.service.booking.app.data.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.data.entity.BookingLimit;
import com.service.booking.app.repository.BookingLimitRepository;

@Service
@Transactional(readOnly = true)
public class BookingLimitServiceImpl implements BookingLimitService{

	@Autowired
	BookingLimitRepository repository;

	@Override
	public List<BookingLimit> findBookingLimitByDatesAndLocatio(LocalDate date, LocalDate date1, LocalDate date2,
			LocalDate date3, Integer locationId) {
		return repository.getBookingLimitByDatesAndLocation(date, date1, date2, date3, locationId);
	}
}
