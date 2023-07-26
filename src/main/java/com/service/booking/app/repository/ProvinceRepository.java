package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Province;

@Repository
public interface ProvinceRepository extends JpaRepository<Province, Integer>{
	
	Province findByProvinceId(Integer provinceId);
	
	@Query("SELECT p FROM Province p WHERE p.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Province> findProvinceByStatus(@Param("statusCode") String statusCode);
}
