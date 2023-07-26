package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Province;
import com.service.booking.app.repository.ProvinceRepository;

@Service
@Transactional(readOnly = true)
public class ProvinceServiceImpl implements ProvinceService {
	@Autowired
	ProvinceRepository repository;
	
	@Override
	public void save(Province province) {
		repository.save(province);
		
	}

	@Override
	public List<Province> findAll() {
		return repository.findProvinceByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public Province getProvince(Integer provinceId) {
		return repository.findByProvinceId(provinceId);
	}

}
