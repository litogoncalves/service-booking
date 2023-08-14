package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.EmailSendingReport;

@Repository
public interface EmailReportRepository extends JpaRepository<EmailSendingReport, String>{

	EmailSendingReport findEmailSendingReportById(String emailReportId);
	
	@Query("SELECT e FROM EmailSendingReport e WHERE e.booking.bookingId = :bookingId")
    List<EmailSendingReport> findEmailSendingReportByBookingId(@Param("bookingId") String bookingId);
}
