package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.repository.ServiceRepository;

@Service
@Transactional(readOnly = true)
public class ServServiceImpl implements ServService{
	@Autowired
	ServiceRepository repository;
	@Override
	public void save(com.service.booking.app.data.entity.Service service) {
		repository.save(service);
		
	}

	@Override
	public List<com.service.booking.app.data.entity.Service> findAll() {
		return repository.findServiceByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public com.service.booking.app.data.entity.Service getService(Integer serviceId) {
		return repository.findByServiceId(serviceId);
	}

	@Override
	public com.service.booking.app.data.entity.Service getServiceByName(String serviceName) {
		return repository.findByServiceName(serviceName);
	}

}
