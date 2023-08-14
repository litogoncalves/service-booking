package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.ServiceFee;
import com.service.booking.app.repository.ServiceFeeRepository;

@Service
@Transactional(readOnly = true)
public class ServFeeServiceImpl implements ServFeeService {
	@Autowired
	ServiceFeeRepository repository;

	@Override
	public void save(ServiceFee serviceFee) {
		repository.save(serviceFee);
		
	}

	@Override
	public List<ServiceFee> findAll() {
		return repository.findServiceFeeByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public ServiceFee getServiceFee(Integer serviceFeeId) {
		return repository.findByServiceFeeId(serviceFeeId);
	}

	@Override
	public List<ServiceFee> findForeignServiceFee() {
		return repository.findForeignServiceFeeByStatus(Constants.STATUS_ACTIVE_CODE);
	}

}
