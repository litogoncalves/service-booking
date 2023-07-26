package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Modality;

@Repository
public interface ModalityRepository extends JpaRepository<Modality,Integer>{
	Modality findByModalityId(Integer modalityId);
	
	@Query("SELECT m FROM Modality m WHERE m.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Modality> findModalityByStatus(@Param("statusCode") String statusCode);
}
