package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.service.booking.app.data.entity.ApplicantData;

public interface ApplicantDataRepository extends JpaRepository<ApplicantData, String>{

	ApplicantData findApplicantDataById(String id);
	
	@Query("SELECT a FROM ApplicantData a WHERE a.bookingId = :bookingId AND a.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<ApplicantData> findApplicantDataByBookingId(@Param("bookingId") String bookingId, @Param("statusCode") String statusCode);
}
