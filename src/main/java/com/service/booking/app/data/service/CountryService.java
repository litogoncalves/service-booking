package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Country;

public interface CountryService {

	public void save(Country country);
	public List<Country> findAll();
	public Country getCountry(Integer countryId);
	public Country getCountryByCode(String code);
}
