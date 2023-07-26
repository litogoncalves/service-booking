package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.IdentityDocument;
import com.service.booking.app.data.entity.Service;

@Repository
public interface IdentityDocumentRepository extends JpaRepository<IdentityDocument,String>{

	Service findByIdentityNumber(String identityNumber);
	
	@Query("SELECT id FROM IdentityDocument id WHERE id.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<IdentityDocument> findIdentityDocumentByStatus(@Param("statusCode") String statusCode);
	
}
