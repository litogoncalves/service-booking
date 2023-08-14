package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Passport;

@Repository
public interface PassportRepository extends JpaRepository<Passport, String> {

	Passport findPassportByPassportNumber(String passportNumber);
	
	@Query("SELECT p FROM Passport p WHERE p.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Passport> findPassportByStatus(@Param("statusCode") String statusCode);
}
