package com.service.booking.app.utils;

import java.util.Date;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.data.entity.BookingLogs;

public class BookingUtils {

	public BookingUtils() {
		
	}
	
	public static BookingLogs setBookingLogsValues(Booking booking) {
		BookingLogs bookingLogs = new BookingLogs();
		
		bookingLogs.setAction(Constants.CANCEL);
		bookingLogs.setActionBy(booking.getNameReq()+" "+booking.getSurnameReq());
		bookingLogs.setActionDate(new Date());
		bookingLogs.setBookingId(booking.getBookingId());
		bookingLogs.setContactoReq(booking.getPhoneNumberReq());
		bookingLogs.setDateToSchedule(booking.getDateToSchedule());
		bookingLogs.setDocumentType(booking.getDocumentType());
		bookingLogs.setEmailReq(booking.getEmailReq());
		bookingLogs.setIdentityDoc(booking.getIdentityDoc());
		bookingLogs.setLocation(booking.getLocation());
		bookingLogs.setModality(booking.getModality());
		bookingLogs.setNameReq(booking.getNameReq());
		bookingLogs.setSurnameReq(booking.getSurnameReq());
		bookingLogs.setService(booking.getService());
		bookingLogs.setServiceFee(booking.getServiceFee());
		bookingLogs.setStatus(booking.getStatus());
		
		
		return bookingLogs;
	}
}
