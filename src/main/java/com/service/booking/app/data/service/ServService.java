package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Service;

public interface ServService {

	public void save(Service service);
	public List<Service> findAll();
	public Service getService(Integer serviceId);
	public Service getServiceByName(String serviceName);
}
