package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Location;

public interface LocationService {

	public void save(Location location);
	public List<Location> findAll();
	public List<Location> findLocationByProvinceId(Integer locationId);
	public Location getLocation(Integer locationId);
}
