package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Integer>{

	Service findByServiceId(Integer serviceId);
	
	@Query("SELECT sv FROM Service sv WHERE sv.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<Service> findServiceByStatus(@Param("statusCode") String statusCode);
	
	@Query("select s from Service s where lower(s.name) like lower(concat('%', :serviceName, '%'))")
	Service findByServiceName(@Param("serviceName") String serviceName);
}
