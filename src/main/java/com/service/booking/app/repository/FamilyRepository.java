package com.service.booking.app.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.service.booking.app.data.entity.Family;

@Repository
public interface FamilyRepository extends JpaRepository<Family, String>{
	
	Family findFamilyById(String familyId);
	
	@Query("SELECT f FROM Family f WHERE f.bookingId = :bookingId AND f.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Family> findFamilyByBookingId(@Param("bookingId") String bookingId, @Param("statusCode") String statusCode);
}
