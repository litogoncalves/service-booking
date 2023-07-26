package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.District;

public interface DistrictService {

	public void save(District district);
	public List<District> findAll();
	public List<District> findDistrictByProvinceId(Integer provinceId);
	public District getDistrict(Integer districtId);
	
}
