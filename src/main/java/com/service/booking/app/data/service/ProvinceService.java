package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Province;

/**
 * @author elexrafael
 *
 */
public interface ProvinceService {

	public void save(Province province);
	public List<Province> findAll();
	public Province getProvince(Integer provinceId);
}
