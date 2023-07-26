package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Nationality;

public interface NationalityService {
	
	public void save(Nationality nationality);
	public List<Nationality> findAll();
	public Nationality getNationality(Integer nationalityId);
}
