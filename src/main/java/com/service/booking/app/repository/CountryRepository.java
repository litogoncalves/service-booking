package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {
	Country findByCountryId(Integer modalityId);
	
	@Query("SELECT c FROM Country c WHERE c.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Country> findCountryByStatus(@Param("statusCode") String statusCode);
	
}
