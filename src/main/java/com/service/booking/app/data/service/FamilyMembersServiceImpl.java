package com.service.booking.app.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.data.entity.FamilyMembers;
import com.service.booking.app.repository.FamilyMembersRepository;

@Service
@Transactional
public class FamilyMembersServiceImpl implements FamilyMembersService {

	@Autowired
	FamilyMembersRepository repository;
	@Override
	public void save(FamilyMembers familyMembers) {
		repository.save(familyMembers);
	}

	@Override
	public List<FamilyMembers> findAll() {
		return repository.findAll();
	}

	@Override
	public List<FamilyMembers> findFamilyMembersByBookingId(String bookingId) {
		return repository.findFamilyMembersByBookingId(bookingId, Constants.STATUS_ACTIVE_CODE);
	}

	@Override
	public FamilyMembers getFamilyMembers(String familyMembersId) {
		return repository.findFamilyMembersById(familyMembersId);
	}

}
