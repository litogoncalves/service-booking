package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.District;
import com.service.booking.app.repository.DistrictRepository;

@Service
@Transactional(readOnly = true)
public class DistrictServiceImpl implements DistrictService {
	@Autowired
	DistrictRepository repository;
	
	@Override
	public void save(District district) {
		repository.save(district);
		
	}

	@Override
	public List<District> findAll() {
		return repository.findDistrictByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public District getDistrict(Integer districtId) {
		return repository.findByDistrictId(districtId);
	}

	@Override
	public List<District> findDistrictByProvinceId(Integer provinceId) {
		return repository.findDistrictByProvinceIdAndStatusCode(provinceId, Constants.STATUS_ACTIVE_CODE);
	}

}
