package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Status;


public interface StatusService {

	public void save(Status status);
	public List<Status> findAll();
	public Status getStatus(Integer statusId); 
	public Status getStatusByCode(String code);
}
