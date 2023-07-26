package com.service.booking.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.service.booking.app.data.entity.ServiceCategory;

@Repository
public interface ServCategoryRepository extends JpaRepository<ServiceCategory, Integer>{
	ServiceCategory findByServCategoryId(Integer servCategoryId);
}
