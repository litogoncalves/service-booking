package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.data.entity.ServiceCategory;
import com.service.booking.app.repository.ServCategoryRepository;

@Service
@Transactional(readOnly = true)
public class ServCategoryServiceImpl implements ServCategoryService{

	@Autowired
	private ServCategoryRepository repository;
	
	@Override
	@Transactional
	public void save(ServiceCategory serviceCategory) {
		repository.save(serviceCategory);
	}

	@Override
	public List<ServiceCategory> findAll() {
		return repository.findAll();
	}

	@Override
	public ServiceCategory getServiceCategory(Integer servCategoryId) {
		return repository.findByServCategoryId(servCategoryId);
	}

}
