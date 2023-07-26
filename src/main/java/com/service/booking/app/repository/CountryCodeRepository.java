package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.CountryCode;

@Repository
public interface CountryCodeRepository extends JpaRepository<CountryCode, Integer>{

	CountryCode findByCountryCodeId(Integer countryCodeId);
	
	@Query("SELECT c FROM CountryCode c WHERE c.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<CountryCode> findCountryCodeByStatus(@Param("statusCode") String statusCode);
	
}
