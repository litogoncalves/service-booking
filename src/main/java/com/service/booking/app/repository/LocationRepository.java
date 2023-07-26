package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	Location findByLocationId(Integer locationId);
	
	@Query("SELECT l FROM Location l WHERE l.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Location> findLocationByStatus(@Param("statusCode") String statusCode);
	
	@Query("SELECT l FROM Location l WHERE l.province.provinceId = :provinceId and l.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Location> findLocationByProvinceIdAndStatusCode(@Param("provinceId") Integer provinceId, @Param("statusCode") String statusCode);
}
