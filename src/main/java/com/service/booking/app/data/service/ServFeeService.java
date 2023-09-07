package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.ServiceFee;

public interface ServFeeService {
	
	public void save(ServiceFee serviceFee);
	public List<ServiceFee> findAll();
	public ServiceFee getServiceFee(Integer serviceFeeId);
	public List<ServiceFee> findForeignServiceFee();
	public List<ServiceFee> findVisaExtendServiceFee();
	
}
