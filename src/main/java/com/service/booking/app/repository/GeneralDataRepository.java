package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Country;
import com.service.booking.app.data.entity.GeneralData;

@Repository
public interface GeneralDataRepository extends JpaRepository<GeneralData, Integer>{

	GeneralData findByGeneralDataId(Integer generalDataId);

	@Query("SELECT g FROM GeneralData g WHERE g.category = :category and g.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<GeneralData> findGeneralDataByCategoryAndStatus(@Param("category") String category, @Param("statusCode") String statusCode);
	
	@Query("SELECT g FROM GeneralData g WHERE g.name = :name and g.category = :category and g.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
	GeneralData findGeneralDataByNameAndStatus(@Param("name") String name, @Param("category") String category, @Param("statusCode") String statusCode);
}
