package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Location;
import com.service.booking.app.repository.LocationRepository;

@Service
@Transactional(readOnly = true)
public class LocationServiceImpl implements LocationService{
	@Autowired
	LocationRepository repository;
	
	@Override
	public void save(Location location) {
		repository.save(location);
		
	}

	@Override
	public List<Location> findAll() {
		return repository.findLocationByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public List<Location> findLocationByProvinceId(Integer locationId) {
		return repository.findLocationByProvinceIdAndStatusCode(locationId, Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public Location getLocation(Integer locationId) {
		return repository.findByLocationId(locationId);
	}

}
