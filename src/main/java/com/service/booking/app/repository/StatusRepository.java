package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
	Status findByStatusId(Integer statusId);
	
	@Query("SELECT s FROM Status s WHERE s.code = :code")
	Status getStatusByCode(@Param("code")  String code);

	@Query("SELECT s FROM Status s WHERE s.code in ('AP', 'NC', 'AA')")
	List<Status> findStatusByCodes();
}
