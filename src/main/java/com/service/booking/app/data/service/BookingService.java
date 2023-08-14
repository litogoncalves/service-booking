package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Booking;

public interface BookingService {

	public void save(Booking booking);
	public List<Booking> findAll();
	public List<Booking> findBookingByIdAndSurnameAndContact(String bookingId, String surname, String phoneOrEmail);
	public List<Booking> findIDDocNumberAndSurnameAndContact(String identityDocId, String surname, String phoneOrEmail);
	public List<Booking> findPassportNumberAndSurnameAndContact(String passportNumber, String surname, String phoneOrEmail);
	public List<Booking> findByPhoneNumberAndStatusAndDate(String bookingId, String statusCode);
	
	public Booking getBookingByIdAndSurnameAndContact(String bookingId, String surname, String phoneOrEmail);
	public Booking getBookingByIDDocNumberAndSurnameAndContact(String identityDocId, String surname, String phoneOrEmail);
	public Booking getBookingByPassportNumberAndSurnameAndContact(String passportNumber, String surname, String phoneOrEmail);
	public Booking getBookingByBookingId(String bookingId);
	public Booking getBookingByIdentityDocNumber(String idNumber);
	public Booking getBookingByIDDocNumberAndStatusAndDate(String idNumber, Integer serviceId, String statusCode);
	public Booking getBookingByPassportNumberAndStatusAndDate(String passportNumber, Integer serviceId, String statusCode);
	
}