package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Nationality;
import com.service.booking.app.repository.NationalityRepository;

@Service
@Transactional(readOnly = true)
public class NationalityServiceImpl implements NationalityService {
	@Autowired
	NationalityRepository repository;

	@Override
	public void save(Nationality nationality) {
		repository.save(nationality);
		
	}

	@Override
	public List<Nationality> findAll() {
		return repository.findModalityByStatus(Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public Nationality getNationality(Integer nationalityId) {
		return repository.findByNationalityId(nationalityId);
	}

}
