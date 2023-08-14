package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.CountryCode;
import com.service.booking.app.repository.CountryCodeRepository;

@Service
@Transactional(readOnly = true)
public class CountryCodeServiceImpl implements CountryCodeService{
	@Autowired
	CountryCodeRepository repository;

	@Override
	public void save(CountryCode countryCode) {
		repository.save(countryCode);
		
	}

	@Override
	public List<CountryCode> findAll() {
		return repository.findCountryCodeByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public CountryCode getCountryCode(Integer countryCodeId) {
		return repository.findByCountryCodeId(countryCodeId);
	}

	@Override
	public CountryCode getCountryCodeByCode(String countryCode) {
		return repository.findCountryCodeByCodeAndStatus(countryCode, Constants.STATUS_ACTIVE_CODE);
	}

}
