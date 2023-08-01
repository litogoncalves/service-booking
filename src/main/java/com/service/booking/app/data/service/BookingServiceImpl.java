package com.service.booking.app.data.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.repository.BookingRepository;

@Service
@Transactional
public class BookingServiceImpl implements BookingService{
	@Autowired
	BookingRepository repository;
	@Override
	public void save(Booking booking) {
		booking.setCreatedDate(new Date());
		booking.setVersion(1);
		if(booking.getCityAddress() == null)
			booking.setCityAddress("N/A");
		
		if(booking.getStreetAddress() == null)
			booking.setStreetAddress("N/A");

		if(booking.getHotelReservation() == null)
			booking.setHotelReservation("N/A");
		
		repository.save(booking);
	}

	@Override
	public List<Booking> findAll() {
		return repository.findBookingByStatus(Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
	}

	@Override
	public Booking getBookingByBookingId(String bookingId) {
		return repository.findByBookingId(bookingId);
	}

	@Override
	public Booking getBookingByIdentityDocNumber(String idNumber) {
		return repository.findBookingByIdentityDocNumber(idNumber);
	}

	@Override
	public List<Booking> findBookingByIdAndSurnameAndContact(String bookingId, String surname, String phoneOrEmail) {
		return repository.findBookingByIdAndSurnameAndContact(bookingId, surname, phoneOrEmail);
	}

	@Override
	public List<Booking> findIDDocNumberAndSurnameAndContact(String identityDocId, String surname,
			String phoneOrEmail) {
		return repository.findByIDDocNumberAndSurnameAndContact(identityDocId, surname, phoneOrEmail);
	}

	@Override
	public Booking getBookingByIdAndSurnameAndContact(String bookingId, String surname, String phoneOrEmail) {
		return repository.getBookingByIdAndSurnameAndContact(bookingId, surname, phoneOrEmail);
	}

	@Override
	public Booking getBookingByIDDocNumberAndSurnameAndContact(String identityDocId, String surname,
			String phoneOrEmail) {
		return repository.getBookingByIDDocNumberAndSurnameAndContact(identityDocId, surname, phoneOrEmail);
	}

}
