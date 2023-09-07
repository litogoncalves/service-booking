package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.data.entity.Status;
import com.service.booking.app.repository.StatusRepository;

@Service
@Transactional(readOnly = true)
public class StatusServiceImpl implements StatusService {
	@Autowired 
	private StatusRepository repository;

	@Override
	// The default value is readOnly = false
	@Transactional
	public void save(Status status) {
		repository.save(status);
		
	}

	@Override
	public List<Status> findAll() {
		return repository.findAll();
		
	}

	@Override
	public Status getStatus(Integer statusId) {
		return repository.findByStatusId(statusId);
	}

	@Override
	public Status getStatusByCode(String code) {
		return repository.getStatusByCode(code);
	}

	@Override
	public List<Status> findStatusByCodes() {
		return repository.findStatusByCodes();
	}

}
