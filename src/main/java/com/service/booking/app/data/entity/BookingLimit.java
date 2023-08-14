package com.service.booking.app.data.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@SqlResultSetMapping(
	    name = "BookingLimitMapping", classes = @ConstructorResult(
	        targetClass = BookingLimit.class, columns = {
	            @ColumnResult(name = "bookingDate", type = LocalDate.class),
	            @ColumnResult(name = "totalDateBookings", type = Integer.class)
	        }
	    )
	)
@NamedNativeQuery(
	    name = "getBookingLimitByDatesAndLocation",
	    query = "SELECT :date as bookingDate, count(b.booking_id) as totalDateBookings FROM booking b WHERE date_to_schedule = :date and b.location_id = :location"
	    		+ "union SELECT :date1 as bookingDate, count(b.booking_id) as totalDateBookings FROM booking b WHERE date_to_schedule = :date1 and b.location_id = :location"
	    		+ "union SELECT :date2 as bookingDate, count(b.booking_id) as totalDateBookings FROM booking b WHERE date_to_schedule = :date2 and b.location_id = :location"
	    		+ "union SELECT :date3 as bookingDate, count(b.booking_id) as totalDateBookings FROM booking b WHERE date_to_schedule = :date3 and b.location_id = :location",
	    resultSetMapping = "BookingLimitMapping"
	)
public class BookingLimit {
	
	private LocalDate bookingDate;
	private Long totalDateBookings;
	
	public BookingLimit() {
	}

	public BookingLimit(LocalDate booking_date, Long total_date_bookings) {
		this.bookingDate = booking_date;
		this.totalDateBookings = total_date_bookings;
	}

	public LocalDate getBooking_date() {
		return bookingDate;
	}

	public void setBooking_date(LocalDate booking_date) {
		this.bookingDate = booking_date;
	}

	public Long getTotal_date_bookings() {
		return totalDateBookings;
	}

	public void setTotal_date_bookings(Long total_date_bookings) {
		this.totalDateBookings = total_date_bookings;
	}

	@Override
	public String toString() {
		return "BookingLimit [bookingDate=" + bookingDate + ", totalDateBookings=" + totalDateBookings + "]";
	}
	
}
