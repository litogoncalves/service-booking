package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Nationality;

@Repository
public interface NationalityRepository extends JpaRepository<Nationality, Integer>{
	Nationality findByNationalityId(Integer nationalityId);
	
	@Query("SELECT n FROM Nationality n WHERE n.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Nationality> findModalityByStatus(@Param("statusCode") String statusCode);
	
	@Query("SELECT n FROM Nationality n WHERE n.countryCode = :code and n.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
	Nationality findNationalityByCode(@Param("code") String code, @Param("statusCode") String statusCode);
}
