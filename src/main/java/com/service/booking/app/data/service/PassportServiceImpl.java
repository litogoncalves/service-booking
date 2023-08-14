package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.data.entity.Passport;

@Service
@Transactional
public class PassportServiceImpl implements PassportService{

	@Autowired
	PassportRepository repository;
	
	@Override
	public void save(Passport passport) {
		repository.save(passport);
	}

	@Override
	public List<Passport> findAll() {
		return repository.findAll();
	}

	@Override
	public Passport getPassport(String passportId) {
		return repository.findPassportByPassportNumber(passportId);
	}

}
