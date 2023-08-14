package com.service.booking.app.data.service;

import java.util.List;

import com.service.booking.app.data.entity.Family;

public interface FamilyService {
	public void save(Family family);
	public List<Family> findAll();
	public List<Family> findFamilyByBookingId(String bookingId);
	public Family getFamily(String familyId);
}
