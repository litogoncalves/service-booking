package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.SmsSendingReport;

@Repository
public interface SmsReportRepository extends JpaRepository<SmsSendingReport, String>{
	
	SmsSendingReport findSmsSendingReportById(String smsReportId);
	
	@Query("SELECT e FROM SmsSendingReport e WHERE e.booking.bookingId = :bookingId")
    List<SmsSendingReport> findSmsSendingReportByBookingId(@Param("bookingId") String bookingId);

}
