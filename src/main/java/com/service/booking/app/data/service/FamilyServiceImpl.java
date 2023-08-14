package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.Family;
import com.service.booking.app.repository.FamilyRepository;

@Service
@Transactional
public class FamilyServiceImpl implements FamilyService {

	@Autowired
	FamilyRepository repository;
	
	@Override
	public void save(Family family) {
		repository.save(family);
	}

	@Override
	public List<Family> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Family> findFamilyByBookingId(String bookingId) {
		return repository.findFamilyByBookingId(bookingId, Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public Family getFamily(String familyId) {
		return repository.findFamilyById(familyId);
	}

}
