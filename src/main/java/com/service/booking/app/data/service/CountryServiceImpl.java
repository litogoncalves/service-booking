package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Country;
import com.service.booking.app.repository.CountryRepository;

@Service
@Transactional(readOnly = true)
public class CountryServiceImpl implements CountryService {
	@Autowired
	CountryRepository repository;

	@Override
	public void save(Country country) {
		repository.save(country);
		
	}

	@Override
	public List<Country> findAll() {
		return repository.findCountryByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public Country getCountry(Integer countryId) {
		return repository.findByCountryId(countryId);
	}

	@Override
	public Country getCountryByCode(String countryCode) {
		return repository.findCountryByCode(countryCode, Constants.STATUS_ACTIVE_CODE);
	}

}
