package com.service.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
	Status findByStatusId(Integer statusId);
	
	@Query("SELECT s FROM Status s WHERE s.code = :code")
	Status getStatusByCode(String code);

}
