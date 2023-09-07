package com.service.booking.app.data.service;

import java.time.LocalDate;
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
		
		booking.setIdNumber("N/A");
		
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

	@Override
	public Booking getBookingByIDDocNumberAndStatusAndDate(String idNumber, Integer ServiceId, String statusCode) {
		return repository.getBookingByIDDocNumberAndStatusAndDate(idNumber, ServiceId, statusCode);
	}

	@Override
	public List<Booking> findByPhoneNumberAndStatusAndDate(String phoneNumber, String statusCode) {
		return repository.findByPhoneNumberAndStatusAndDate(phoneNumber, statusCode);
	}

	@Override
	public List<Booking> findPassportNumberAndSurnameAndContact(String passportNumber, String surname,
			String phoneOrEmail) {
		return repository.findByPassportNumberAndSurnameAndContact(passportNumber, surname, phoneOrEmail);
	}

	@Override
	public Booking getBookingByPassportNumberAndSurnameAndContact(String passportNumber, String surname,
			String phoneOrEmail) {
		return repository.getBookingByPassportNumberAndSurnameAndContact(passportNumber, surname, phoneOrEmail);
	}

	@Override
	public Booking getBookingByPassportNumberAndStatusAndDate(String passportNumber, Integer serviceId,
			String statusCode) {
		return repository.getBookingByPassportNumberAndStatusAndDate(passportNumber, serviceId, statusCode);
	}

	@Override
	public List<Booking> findByFilters(LocalDate dateFrom, LocalDate dateTo, String statusCode) {
		return repository.findByDatesAndStatus(dateFrom, dateTo, statusCode);
	}

	@Override
	public List<Booking> findByAllFilters(LocalDate dateFrom, LocalDate dateTo, int documentId, int locationId, String statusCode) {
		return repository.findByAllFilters(dateFrom, dateTo, documentId, locationId, statusCode);
	}

	@Override
	public List<Booking> findByLocationAndFilters(LocalDate dateFrom, LocalDate dateTo, int locationId, String statusCode) {
		return repository.findByLocationAndStatus(dateFrom, dateTo, locationId, statusCode);
	}

	@Override
	public List<Booking> findByDocAndFilters(LocalDate dateFrom, LocalDate dateTo, int documentId, String statusCode) {
		return repository.findByDocAndStatus(dateFrom, dateTo, documentId, statusCode);
	}	
	
}
