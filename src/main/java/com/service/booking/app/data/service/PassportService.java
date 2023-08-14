package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Passport;

public interface PassportService {
	
	public void save(Passport passport);
	public List<Passport> findAll();
	public Passport getPassport(String passportId);
}
