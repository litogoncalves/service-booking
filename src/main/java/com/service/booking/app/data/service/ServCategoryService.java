package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.ServiceCategory;

public interface ServCategoryService {
	public void save(ServiceCategory serviceCategory);
	public List<ServiceCategory> findAll();
	public ServiceCategory getServiceCategory(Integer servCategoryId);
}
