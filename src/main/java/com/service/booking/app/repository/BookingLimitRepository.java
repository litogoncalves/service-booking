package com.service.booking.app.repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.BookingLimit;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class BookingLimitRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<BookingLimit> getBookingLimitByDatesAndLocation(LocalDate bookingDate, LocalDate bookingDate1, LocalDate bookingDate2,
				LocalDate bookingDate3, Integer locationId) {
	        String nativeQuery = "SELECT :date as bookingDate, count(b.booking_id) as totalDateBookings FROM booking b WHERE date_to_schedule = :date and b.location_id = :location "
		    		+ "union SELECT :date1 as bookingDate, count(b.booking_id) as totalDateBookings FROM booking b WHERE date_to_schedule = :date1 and b.location_id = :location "
		    		+ "union SELECT :date2 as bookingDate, count(b.booking_id) as totalDateBookings FROM booking b WHERE date_to_schedule = :date2 and b.location_id = :location "
		    		+ "union SELECT :date3 as bookingDate, count(b.booking_id) as totalDateBookings FROM booking b WHERE date_to_schedule = :date3 and b.location_id = :location ";
	        
	        @SuppressWarnings("unchecked")
			List<Object[]> resultList = entityManager.createNativeQuery(nativeQuery)
	        		.setParameter("date", bookingDate)
	                .setParameter("date1", bookingDate1)
	                .setParameter("date2", bookingDate2)
	                .setParameter("date3", bookingDate3)
	                .setParameter("location", locationId)
	                .getResultList();

	        List<BookingLimit> bookingLimits = new ArrayList<>();
	        for (Object[] result : resultList) {
	        	String date = (String) result[0];
	            Long totalBookings = (Long) result[1];
	            
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            LocalDate localDate = LocalDate.parse(date, formatter);

	            bookingLimits.add(new BookingLimit(localDate, totalBookings));
	        }

	        return bookingLimits;
	    }
}
