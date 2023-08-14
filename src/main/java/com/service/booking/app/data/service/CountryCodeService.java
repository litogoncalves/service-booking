package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.CountryCode;

public interface CountryCodeService {

	public void save(CountryCode countryCode);
	public List<CountryCode> findAll();
	public CountryCode getCountryCode(Integer countryCodeId);
	public CountryCode getCountryCodeByCode(String countryCode);
}
