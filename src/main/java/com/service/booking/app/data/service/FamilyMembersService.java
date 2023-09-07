package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.FamilyMembers;

public interface FamilyMembersService {
	public void save(FamilyMembers family);
	public List<FamilyMembers> findAll();
	public List<FamilyMembers> findFamilyMembersByBookingId(String bookingId);
	public FamilyMembers getFamilyMembers(String familyId);
}
