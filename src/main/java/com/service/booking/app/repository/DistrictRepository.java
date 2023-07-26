package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{
	District findByDistrictId(Integer districtId);
	
	@Query("SELECT d FROM District d WHERE d.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<District> findDistrictByStatus(@Param("statusCode") String statusCode);
	
	@Query("SELECT d FROM District d WHERE d.province.provinceId = :provinceId and d.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<District> findDistrictByProvinceIdAndStatusCode(@Param("provinceId") Integer provinceId, @Param("statusCode") String statusCode);
}
