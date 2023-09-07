package com.service.booking.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.booking.app.data.entity.FamilyMembers;

@Repository
public interface FamilyMembersRepository extends JpaRepository<FamilyMembers, String>{
	
	FamilyMembers findFamilyMembersById(String id);
	
	@Query("SELECT f FROM FamilyMembers f WHERE f.bookingId = :bookingId AND f.status.statusId = (SELECT s.statusId FROM Status s WHERE s.code = :statusCode)")
    List<FamilyMembers> findFamilyMembersByBookingId(@Param("bookingId") String bookingId, @Param("statusCode") String statusCode);
}
