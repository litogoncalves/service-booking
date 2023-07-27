package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.BookingLogs;

@Repository
public interface BookingLogsRepository extends JpaRepository<BookingLogs, String>{
	
	BookingLogs findBookingLogsByBookingLogsId(String bookingLogsId);
	
	@Query("SELECT b FROM BookingLogs b WHERE b.bookingId = :bookingId")
	List<BookingLogs> findBookingLogsByBookingId(@Param("bookingId") String bookingId);
	
}
