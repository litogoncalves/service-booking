package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{
	Document findByDocumentId(Integer documentId);
	
	@Query("SELECT d FROM Document d WHERE d.category = :category AND d.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Document> findDocumentsByCaregoryAndStatus(@Param("category") String category, @Param("statusCode") String statusCode);
	
	@Query("SELECT d FROM Document d WHERE d.name in ('novo', 'new', 'Nouveau') and d.category = :category AND d.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Document> findForeignDocs(@Param("category") String category, @Param("statusCode") String statusCode);
}
