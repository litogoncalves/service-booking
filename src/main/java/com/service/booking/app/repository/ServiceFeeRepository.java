package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.ServiceFee;

@Repository
public interface ServiceFeeRepository extends JpaRepository<ServiceFee,Integer>{
	ServiceFee findByServiceFeeId(Integer serviceFeeId);
	
	@Query("SELECT f FROM ServiceFee f WHERE f.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<ServiceFee> findServiceFeeByStatus(@Param("statusCode") String statusCode);

	@Query("SELECT f FROM ServiceFee f WHERE f.name in ('Normal', 'Normale') and f.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<ServiceFee> findForeignServiceFeeByStatus(@Param("statusCode") String statusCode);
}
